package com.github.monchenkoid.research.source;

/**
 * Created by shiza on 29.10.2014.
 */
public interface DataSource<Result, Params> {

    Result getResult(Params params) throws Exception;

}
