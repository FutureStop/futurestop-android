/**
 * 
 */
package com.github.futurestop.builder;

import com.github.futurestop.model.FSResult;
import com.github.futurestop.request.FSRequest;
import com.google.gson.Gson;

/**
 * @author Chung-Yi Cho
 *
 */
public class SampleBuilder implements IBuilder {

    @SuppressWarnings("unchecked")
    @Override
    public <T> FSResult<T> execute(FSRequest reqeust) {
        Gson gson = new Gson();
        String str = gson.fromJson(gson.toJson("Hello Sample Builder"), String.class);
        
        //dd
        FSResult<String> result = new FSResult<String>();
        result.data = str;
        
        return (FSResult<T>) result;
    }

}
