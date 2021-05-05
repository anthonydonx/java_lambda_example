/**
 * @author anthonydonx
 */
package com.techlearnlab;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.SQSEvent;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class SimpleLambda implements RequestHandler<SQSEvent,String>{
    //private static final Logger logger = LoggerFactory.getLogger(SimpleLambda.class);

    /**
     * Handles a Lambda Function request
     *
     * @param sqsEventInput   The Lambda Function input
     * @param context The Lambda execution environment context object.
     * @return The Lambda Function output
     */
    @Override
    public String handleRequest(SQSEvent sqsEventInput, Context context) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        LambdaLogger logger=context.getLogger();
        logger.log("lambda function triggered!");
        logger.log("CONTEXT IS: {}"+ gson.toJson(context));
        logger.log("EVENT IS: {}"+gson.toJson(sqsEventInput));
//        for(SQSEvent.SQSMessage msg : sqsEventInput.getRecords()){
//            logger.info(msg.getBody());
//        }
        return "lambda return!";
    }
}
