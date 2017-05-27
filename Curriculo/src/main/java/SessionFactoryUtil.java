import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

/***
 * Session Factory Util Class - Version 1
 * 
 * @author Adriano A. Santos
 *
 */
public class SessionFactoryUtil {

	static StandardServiceRegistry registry = null;
	
	public static SessionFactory createSessionFactory(){
		if (registry == null){
			try {
				registry = new StandardServiceRegistryBuilder()
						.configure()
						.build();
			} catch (Exception e) {
				e.printStackTrace();
				StandardServiceRegistryFactoryDestroy();
			}
		}
		return new MetadataSources( registry ).buildMetadata().buildSessionFactory();
	}
	
	public static void destroySessionFactoty(){
		StandardServiceRegistryFactoryDestroy();
	}
	
	private static void StandardServiceRegistryFactoryDestroy() {
		if(registry != null){
			try {
				StandardServiceRegistryBuilder.destroy( registry );
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}	
}
