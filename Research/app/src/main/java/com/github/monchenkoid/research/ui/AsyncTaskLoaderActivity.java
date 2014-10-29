package com.github.monchenkoid.research.ui;

        import android.os.Bundle;
        import android.support.v4.app.FragmentActivity;
        import android.support.v4.app.FragmentManager;
        import android.support.v4.app.FragmentTransaction;
        import android.widget.FrameLayout;

import com.github.monchenkoid.research.R;
import com.github.monchenkoid.research.loaders.ListFragmentExp;

/**
 * Created by Irina Monchenko on 29.10.2014.
 */
public class AsyncTaskLoaderActivity  extends FragmentActivity {
    FragmentTransaction mTFragmentTransaction;
    FragmentManager mManFragmentManager;
    ListFragmentExp mListFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.async_loader);
        mListFragment = new ListFragmentExp();
        FrameLayout cursor = (FrameLayout) findViewById(R.id.listFragment);
        mManFragmentManager = getSupportFragmentManager();

        if (mManFragmentManager.findFragmentByTag("Tag") == null) {
            mTFragmentTransaction = mManFragmentManager.beginTransaction();
            mTFragmentTransaction.add(cursor.getId(), mListFragment, "Tag");
            mTFragmentTransaction.commit();
        }
    }
}
