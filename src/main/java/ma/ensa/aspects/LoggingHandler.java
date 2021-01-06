package ma.ensa.aspects;

import ma.ensa.beans.Client;
import ma.ensa.beans.Compte;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

import java.util.Arrays;
import java.util.logging.Logger;


public class LoggingHandler implements MethodInterceptor {

        private Logger logger = Logger.getLogger(this.getClass().getName());


    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        Client client=(Client) methodInvocation.getThis();
        long t1=System.currentTimeMillis();

        if (methodInvocation.getMethod().getName().equals("retirer")){
           if(client.getCp().getSolde()  > (Double)methodInvocation.getArguments()[0]){
               logger.info("Method name : " + methodInvocation.getMethod().getName());
               logger.info("Method arguments : " +
                       Arrays.toString(methodInvocation.getArguments()));
               logger.info(client.getCp().getSolde()+" SOLDE AVANT DEBIT ");
               Object result = methodInvocation.proceed();
               long t2=System.currentTimeMillis();
               logger.info(client.getCp().getSolde()+" SOLDE APRES DEBIT ");
               logger.info("TEMPS EXECUTION " + (t2-t1));
               return result;
           }else logger.info("INSUFFISANT");
        }
        if(methodInvocation.getMethod().getName().equals("verser")){
            logger.info("Method name : " + methodInvocation.getMethod().getName());
            logger.info("Method arguments : " +
                    Arrays.toString(methodInvocation.getArguments()));
            logger.info(client.getCp().getSolde()+" SOLDE AVANT VERSEMENT ");
            Object result = methodInvocation.proceed();
            long t2=System.currentTimeMillis();
            logger.info(client.getCp().getSolde()+" SOLDE APRES VERSEMENT ");
            logger.info("TEMPS EXECUTION " + (t2-t1));
            return result;
        }

        return null;


    }
}
