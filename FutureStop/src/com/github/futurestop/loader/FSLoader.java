/**
 * 
 */
package com.github.futurestop.loader;

import android.content.Context;
import android.support.v4.content.AsyncTaskLoader;

import com.github.futurestop.model.FSResult;
import com.github.futurestop.request.FSRequest;

/**
 * @author Chung-Yi Cho
 *
 */
public class FSLoader extends AsyncTaskLoader<FSResult<String>> {

    private FSResult<String> mData;
    public FSRequest mRequest;
    
    public FSLoader(Context context) {
        super(context);
    }

    @Override
    public FSResult<String> loadInBackground() {
        return mRequest.builder.execute(mRequest);
    }
    
    /**
     * Called when there is new data to deliver to the client.  The
     * super class will take care of delivering it; the implementation
     * here just adds a little more logic.
     */
    @Override 
    public void deliverResult(FSResult<String> data) {
        if (isReset()) {
            // An async query came in while the loader is stopped.  We
            // don't need the result.
            if (data != null) {
                onReleaseResources(data);
            }
        }
        
        FSResult oldData = data;
        mData = data;

        if (isStarted()) {
            // If the Loader is currently started, we can immediately
            // deliver its results.
            super.deliverResult(data);
        }

        // At this point we can release the resources associated with
        // 'oldApps' if needed; now that the new result is delivered we
        // know that it is no longer in use.
        if (oldData != null) {
            onReleaseResources(oldData);
        }
    }
    
    /**
     * Handles a request to start the Loader.
     */
    @Override protected void onStartLoading() {
        if (mData != null) {
            // If we currently have a result available, deliver it
            // immediately.
            deliverResult(mData);
        }
        
        if (mData == null) {
            // If the data has changed since the last time it was loaded
            // or is not currently available, start a load.
            forceLoad();
        }
    }
    
    /**
     * Handles a request to stop the Loader.
     */
    @Override protected void onStopLoading() {
        // Attempt to cancel the current load task if possible.
        cancelLoad();
    }
    
    /**
     * Handles a request to cancel a load.
     */
    @Override public void onCanceled(FSResult data) {
        super.onCanceled(data);

        // At this point we can release the resources associated with 'apps'
        // if needed.
        onReleaseResources(data);
    }
    
    /**
     * Handles a request to completely reset the Loader.
     */
    @Override protected void onReset() {
        super.onReset();

        // Ensure the loader is stopped
        onStopLoading();

        // At this point we can release the resources associated with 'apps'
        // if needed.
        if (mData != null) {
            onReleaseResources(mData);
            mData = null;
        }
    }
    
    /**
     * Helper function to take care of releasing resources associated
     * with an actively loaded data set.
     */
    protected void onReleaseResources(FSResult data) {

    }

}
