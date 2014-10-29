package com.github.monchenkoid.research.helper;

import android.content.Context;
import android.os.Handler;
import android.support.v4.content.Loader;
import android.util.Log;

import com.github.monchenkoid.research.os.AsyncTask;
import com.github.monchenkoid.research.processing.Processor;
import com.github.monchenkoid.research.source.DataSource;


/**
 * Created by shiza on 29.10.2014.
 */
public class DataManager {

    public static final boolean IS_ASYNC_TASK = false;
    public static final boolean IS_LOADER = false;

    public static interface Callback<Result> {
        void onDataLoadStart();

        void onDone(Result data);

        void onError(Exception e);
    }

    public static <ProcessingResult, DataSourceResult, Params> void
    loadData(
            final Callback<ProcessingResult> callback,
            final Params params,
            final DataSource<DataSourceResult, Params> dataSource,
            final Processor<ProcessingResult, DataSourceResult> processor) {
        if (callback == null) {
            throw new IllegalArgumentException("callback can't be null");
        }
        if (IS_ASYNC_TASK) {
            executeInAsyncTask(callback, params, dataSource);
        } else if(IS_LOADER){
            executeInLoader( callback, params, dataSource, processor);
        }
    }

    private static <ProcessingResult, DataSourceResult, Params> void
    executeInAsyncTask(
            final Callback<ProcessingResult> callback,
            final Params params,
            final DataSource<DataSourceResult, Params> dataSource) {
        new AsyncTask<Params, Void, ProcessingResult>() {

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                callback.onDataLoadStart();
            }

            @Override
            protected void onPostExecute(ProcessingResult processingResult) {
                super.onPostExecute(processingResult);
                callback.onDone(processingResult);
            }

            @Override
            protected ProcessingResult doInBackground(Params... params) throws Exception {
                Log.d("asynctask","asynctask");
                return (ProcessingResult) dataSource.getResult((Params) params);
            }

            @Override
            protected void onPostException(Exception e) {
                callback.onError(e);
            }

        }.execute(params);
    }

    private static <ProcessingResult, DataSourceResult, Params> void
    executeInThread(
            final Callback<ProcessingResult> callback,
            final Params params,
            final DataSource<DataSourceResult, Params> dataSource,
            final Processor<ProcessingResult, DataSourceResult> processor) {

        final Handler handler = new Handler();
        callback.onDataLoadStart();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Log.d("thread","thread");
                    final DataSourceResult result = dataSource.getResult(params);
                    final ProcessingResult processingResult = processor.process(result);
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            callback.onDone(processingResult);
                        }
                    });
                } catch (final Exception e) {
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            callback.onError(e);
                        }
                    });
                }
            }
        }).start();
    }

    private static <ProcessingResult, DataSourceResult, Params> void
    executeInLoader(


            final Callback<ProcessingResult> callback,
            final Params params,
            final DataSource<DataSourceResult, Params> dataSource,
            final Processor<ProcessingResult, DataSourceResult> processor) {
        new Loader<ProcessingResult>((Context) callback) {
            private ProcessingResult processingResult;

            @Override
            protected void onStartLoading() {
                super.onStartLoading();
                callback.onDataLoadStart();
            }

            @Override
            protected void onStopLoading() {
                super.onStopLoading();

            }

            @Override
            protected void onForceLoad(){
                super.onForceLoad();
                callback.onDone(processingResult);
                ProcessingResult processingRes = null;

                try {
                    processingRes = getPrRes();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                deliverResult(processingRes);
                Log.d("LOADER","loader");
            }

            ProcessingResult getPrRes() throws Exception{
               ProcessingResult processingRes = (ProcessingResult) dataSource.getResult((Params) params);
               return processingRes;
            }

        }.isStarted();
    }


}
