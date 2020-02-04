package testeSelenium;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import junit.framework.Assert;

public class TestEmailLogin {

	static Logger logger = Logger.getLogger(TestEmailLogin.class);

	WebDriver driver;

	// Todos os metodos tem uma @ (anotacao) antes

	@Before
	public void init() throws Throwable {

		// Indica caminho do puglin // aponta o caminho do browser
		System.setProperty("webdriver.chrome.driver", "D:\\Users\\rcassia\\Documents\\chromedriver_win32\\chromedriver.exe");
		// chama o browser
		this.driver = new ChromeDriver();
		// chama o site
		this.driver.get("http://demo.guru99.com/");
		// gerencia a janela e max a janela
		this.driver.manage().window().maximize();
		// temporizadorSystem.out.println("Fim da Etapa 4");
		logger.info("Fim da Etapa 4 - Registro no Log");
		Thread.sleep(500);
	}

	@After
	public void finish() throws Throwable {
		//this.driver.quit();
	}

	String email = "raquelteste@teste.com";

	@Test
	public void etapas() throws Throwable {
		System.out.println("Executando..");
		Thread.sleep(500);

		// enviando email para o campo
		logger.info("Inicio Etapa 1 - Enviar e-mail p/ o site");
		logger.info("Email registrado " + email);
		this.driver.findElement(By.name("emailid")).sendKeys("raquelteste@teste.com");

		// clicando no botão
		logger.info("click no botão ara envio do email");
		this.driver.findElement(By.name("btnLogin")).click();

		Thread.sleep(500);
		System.out.println("Fim da Etapa 1");

		// registrando no arquivo
		logger.info("Fim da Etapa 1 - Registro de log");
		logger.info("\n");

		/*---------------------------------------------------*/

		logger.info("Inicio da Etapa 2 - Capturar os dados");
		System.out.println("Inicio da Etapa 2 - Capturar os dados");

		// capturando os dados
		WebElement userid = this.driver.findElement(By.xpath("/html/body/table/tbody/tr[4]/td[2]"));
		WebElement senha = this.driver.findElement(By.xpath("/html/body/table/tbody/tr[5]/td[2]"));

		System.out.println(userid.getText() + ", " + senha.getText());
		System.out.println("Fim da Etapa 2");

		// registrando no arquivo
		logger.info("O nome do usuário é: " + userid.getText());
		logger.info("Sua senha é: " + senha.getText());
		logger.info("Fim da Etapa 2 - Registro de log");
		logger.info("\n");

		/*---------------------------------------------------*/
		System.out.println("Fim da Etapa 4");
		logger.info("Fim da Etapa 4 - Registro no Log");
		// transformando campo em text
		String uidtext = userid.getText().toString();
		String senhatext = senha.getText().toString();

		System.out.println("Inicio da Etapa 3");
		logger.info("Inicio da Etapa 3 - Login no site");

		Thread.sleep(700);
		logger.info("Entra no site de login");
		this.driver.get("http://demo.guru99.com/V1/index.php");

		// passsando user
		logger.info("Passa o id resgatado: " + uidtext);
		this.driver.findElement(By.name("uid")).sendKeys(uidtext);
		Thread.sleep(500);

		// passsando senha
		logger.info("Passa a senha resgatada: " + senhatext);
		this.driver.findElement(By.name("password")).sendKeys(senhatext);
		Thread.sleep(500);

		// clicando no botão
		logger.info("Clicando no botão para Login");
		this.driver.findElement(By.name("btnLogin")).click();

		System.out.println("Fim da etapa 3");
		logger.info("Fim da etapa 3 - Registro de Log");
		logger.info("\n");

		/*---------------------------------------------------*/

		System.out.println("Incido da Etapa 4");
		logger.info("Inicio da Etapa 4 - Logout");

		// Resgatando o elemento
		logger.info("Resgatando o elemento log out na tela");
		WebElement logout = this.driver.findElement(By.xpath("/html/body/div[3]/div/ul/li[10]/a"));
		
		//pegando o texto de logout
		String resposta = logout.getText();
		
		//imprimir o texto 
		System.out.println(resposta);
		
		//Gaava reposta no Log
		logger.info("Resposta gravada no arquivo de Login");
		logger.info("Texto: " + resposta);
		
		//Registra resultado do teste no Log
		logger.info("Resultado do Teste: " + resposta.equals("Log out"));
		Thread.sleep(500);
		
		//sair 
		this.driver.get("http://demo.guru99.com/V1/html/Logout.php");
		
		System.out.println("Fim da Etapa 4");
		logger.info("Fim da Etapa 4 - Registro no Log - The End");
		logger.info("\n");
		logger.info("--------------------------------------------------");
		logger.info("\n");
		
		//Testando validacao (Verde e Vermelho)
		Assert.assertEquals("Log out", resposta);
		
		
		
		
		
		
		
		
		
		
		

		

	}

}
