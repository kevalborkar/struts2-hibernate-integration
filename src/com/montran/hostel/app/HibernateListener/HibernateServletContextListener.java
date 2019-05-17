package com.montran.hostel.app.HibernateListener;

import java.net.URL;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateServletContextListener implements ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		URL url = HibernateServletContextListener.class.getResource("/hibernate.cfg.xml");
		Configuration config = new Configuration();
		config.configure(url);
		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(config.getProperties())
				.build();
		SessionFactory sessionfactory = config.buildSessionFactory(serviceRegistry);
		sce.getServletContext().setAttribute("SessionFactory", sessionfactory);

	}

	@Override
	public void contextDestroyed(ServletContextEvent servletContextEvent) {
		SessionFactory sf = (SessionFactory) servletContextEvent.getServletContext().getAttribute("SessionFactory");
		sf.close();

	}

}
