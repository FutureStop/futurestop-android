/**
 * 
 */
package com.github.futurestop.builder;

import com.github.futurestop.model.FSResult;
import com.github.futurestop.request.FSRequest;

/**
 * @author Chung-Yi Cho
 *
 */
public class SampleBuilder implements IBuilder {

    @SuppressWarnings("unchecked")
    @Override
    public <T> FSResult<T> execute(FSRequest reqeust) {
        FSResult<String> result = new FSResult<String>();
        result.data = "Hello Chung-Yi Builder";
        return (FSResult<T>) result;
    }

}
