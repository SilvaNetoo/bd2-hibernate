import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

public class TesteCurriculo {

	@Test
	public void testeCurriculo() {
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

		Session session = sessionFactory.openSession();

		Curriculo curriculo1 = new Curriculo();
		curriculo1.setDataAtualizacao("18/05/2017");
		curriculo1.setIdioma("pt-br");

		Curriculo curriculo2 = new Curriculo();
		curriculo2.setDataAtualizacao("18/05/2017");
		curriculo2.setIdioma("pt-br");

		Curriculo curriculo3 = new Curriculo();
		curriculo3.setDataAtualizacao("18/05/2017");
		curriculo3.setIdioma("pt-br");

		session.save(curriculo1);
		session.save(curriculo2);
		session.save(curriculo3);

		Experiencia experiencia1 = new Experiencia();
		experiencia1.setDataInicio("18/05/2017");
		experiencia1.setDataConclusao("18/05/2017");
		experiencia1.setTitulo("Graduando: Bacharelado - Sistemas de Informação");
		experiencia1.setLocal("Centro Universitário - Faculdade de Ciências Sociais " + "Aplicadas - UniFACISA");
		experiencia1.setCurriculo(curriculo1);

		Experiencia experiencia2 = new Experiencia();
		experiencia2.setDataInicio("18/05/2017");
		experiencia2.setDataConclusao("18/05/2017");
		experiencia2.setTitulo("Graduando: Bacharelado - Sistemas de Informação");
		experiencia2.setLocal("Centro Universitário - Faculdade de Ciências Sociais " + "Aplicadas - UniFACISA");
		experiencia2.setCurriculo(curriculo2);

		Experiencia experiencia3 = new Experiencia();
		experiencia3.setDataInicio("18/05/2017");
		experiencia3.setDataConclusao("18/05/2017");
		experiencia3.setTitulo("Graduando: Bacharelado - Sistemas de Informação");
		experiencia3.setLocal("Centro Universitário - Faculdade de Ciências Sociais " + "Aplicadas - UniFACISA");
		experiencia3.setCurriculo(curriculo3);

		session.save(experiencia1);
		session.save(experiencia2);
		session.save(experiencia3);

		Pessoa pessoa1 = new Pessoa();
		pessoa1.setNome("Neto");
		pessoa1.setCpf("0000000000");
		pessoa1.setCurriculo(curriculo1);

		Pessoa pessoa2 = new Pessoa();
		pessoa2.setNome("Victor");
		pessoa2.setCpf("0000000000");
		pessoa2.setCurriculo(curriculo2);

		Pessoa pessoa3 = new Pessoa();
		pessoa3.setNome("Mysael");
		pessoa3.setCpf("0000000000");
		pessoa3.setCurriculo(curriculo3);

		session.save(pessoa1);
		session.save(pessoa2);
		session.save(pessoa3);

		session.beginTransaction().commit();

		session.close();
	}

	@Test
	public void testAtualizacao() {
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

		Session session = sessionFactory.openSession();

		Transaction t = session.beginTransaction();

		Pessoa pessoa = new Pessoa();
		pessoa.setCpf("1111111111");
		pessoa.setNome("att pessoa");
		pessoa.setId(5);
		session.update(pessoa);
		t.commit();
		session.close();
	}

	@Test
	public void testDelete() {
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

		Session session = sessionFactory.openSession();
		Transaction t = session.beginTransaction();

		Pessoa pessoa = new Pessoa();
		pessoa.setId(72);
		session.delete(pessoa);
		t.commit();
		session.close();
	}
	
	@Test
	public void testConsultaExperiencias() {
		
		List<Pessoa> pessoas = new ArrayList<Pessoa>();
		Transaction t = null;
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		try{
			t = session.beginTransaction();
			pessoas = session.createQuery("from Pessoa").list();
			System.out.println(pessoas);
		} catch(RuntimeException e){
			e.printStackTrace();
		} finally {
            session.flush();
            session.close();
        }
	}

}
