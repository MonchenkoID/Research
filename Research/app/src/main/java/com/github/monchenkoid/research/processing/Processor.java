package com.github.monchenkoid.research.processing;

/**
 * Created by shiza on 29.10.2014.
 */
public interface Processor<ProcessingResult, Source> {

    ProcessingResult process(Source source) throws Exception;

}
