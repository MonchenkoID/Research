package com.github.monchenkoid.research.processing;

/**
 * Created by shiza on 29.10.2014.
 */
public class RedirectProcessor<DataSourceResult> implements Processor<DataSourceResult, DataSourceResult> {
    @Override
    public DataSourceResult process(DataSourceResult dataSourceResult) throws Exception {
        return dataSourceResult;
    }
}
