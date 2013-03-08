/**
 * 
 */
package com.github.futurestop.loader;

import android.content.Context;

import com.github.futurestop.model.FSModel;

/**
 * @author Chung-Yi Cho
 *
 */
public class SampleLoader extends FSLoader<String> {

    public SampleLoader(Context context) {
        super(context);
    }

    @Override
    protected FSModel<String> onLoadInBackground() {
        FSModel<String> result = new FSModel<String>();
        result.data = "Sample String";
        return result;
    }
}
