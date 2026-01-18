/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tuonglh.listener;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 *
 * @author USER
 */
public class MyContextListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("Deployingg ..........");
        ServletContext context = sce.getServletContext();
        String siteMapsFile = context.getInitParameter("SITEMAPS_FILE_PATH"); // site map tu context Servlet la file Path
        // muon doc file thi phair co inputsteeam
        InputStream is = null;
        // ho tro hashmap voi properties
        Properties siteMaps = new Properties();   // la hashmap

        try {
            is = context.getResourceAsStream(siteMapsFile);// doc file giup minh luon 
            siteMaps.load(is);

            // day hash map propre len toan cuc 
            context.setAttribute("SITEMAPS", siteMaps);
        } catch (IOException ex) {
            context.log("IO:" + ex.getMessage());
        } finally {
            if (is != null) {
                try {
                    is.close();
                } catch (IOException ex) {
                    context.log("IO: " + ex.getMessage());
                }
            }
        }

    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("Undeploying........");
    }
}
