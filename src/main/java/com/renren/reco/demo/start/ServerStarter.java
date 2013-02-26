package com.renren.reco.demo.start;

import net.paoding.rose.scanning.context.RoseAppContext;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import Ice.Object;

public class ServerStarter {

    /**
     * @param args
     */
    public static void main(String[] args) {

        System.out.println("start");
        RoseAppContext rose = new RoseAppContext();
        String xmlLocation = "resources/spring/applicationContext-*.xml";
        ApplicationContext context = new FileSystemXmlApplicationContext(
                new String[] { xmlLocation }, rose);

        Ice.Communicator ic = null;
        try {
            ic = Ice.Util.initialize(args);
            Ice.ObjectAdapter adapter = ic.createObjectAdapterWithEndpoints(
                    "RecommandServiceAdapter", "default -p 10007");

            adapter.add((Object) context.getBean("recommandService"),
                    Ice.Util.stringToIdentity("RecommandService"));

            adapter.activate();
            System.out.println("success");
            ic.waitForShutdown();
        } catch (Ice.LocalException e) {
            e.printStackTrace();
            System.out.println("fail");
            e.printStackTrace();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        } finally {
            if (ic != null) ic.destroy();
        }

    }
}