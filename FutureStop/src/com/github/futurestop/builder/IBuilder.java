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
public interface IBuilder {
    public <T> FSResult<T> execute(FSRequest reqeust);
}
