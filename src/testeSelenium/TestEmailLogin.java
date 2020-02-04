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
		System.setProperty("webdriver.chrome.driver",
				"D:\\Users\\rcassia\\Documents\\chromedriver_win32\\chromedriver.exe");
		// chama o browser
		this.driver = new ChromeDriver();
		// chama o site
		this.driver.get("http://demo.guru99.com/");
		// gerencia a janela e max a janela
		this.driver.manage().window().maximize();

		logger.info("\n");
		// temporizador
		Thread.sleep(500);
	}

	@After
	public void finish() throws Throwable {
		// this.driver.close();
		// Caixa em JavaScript 
	}

	String email = "raquelteste@teste.com";

	@Test
	public void etapas() throws Throwable {
		
		logger.info("Etapa 1 - Fazer Cadastro no Site");
		
		logger.info("Executando..");
		
		Thread.sleep(500);

		// enviando email para o campo
		logger.info("Entrando no site");
		logger.info("Email registrado " + email);
		this.driver.findElement(By.name("emailid")).sendKeys("raquelteste@teste.com");

		// clicando no bot√£o
		logger.info("click no botao para envio do email");
		this.driver.findElement(By.name("btnLogin")).click();

		Thread.sleep(500);

		// registrando no arquivo
		logger.info("Fim da Etapa 1 - Registro de log");
		logger.info("\n");

		/*---------------------------------------------------*/

		logger.info("Etapa 2 - Capturar os dados");

		// capturando os dados
		WebElement userid = this.driver.findElement(By.xpath("/html/body/table/tbody/tr[4]/td[2]"));
		WebElement senha = this.driver.findElement(By.xpath("/html/body/table/tbody/tr[5]/td[2]"));

		// transformando campo em text
		String uidtext = userid.getText().toString();
		String senhatext = senha.getText().toString();

		// registrando os dados no arquivo
		logger.info("O nome do usu·rio: " + userid.getText());
		logger.info("Sua senha È: " + senha.getText());
		logger.info("Fim da Etapa 2 - Registro de log");
		logger.info("\n");

		/*---------------------------------------------------*/

		logger.info("Etapa 3 - Login no site");

		Thread.sleep(700);
		logger.info("Entra no site de login");
		this.driver.get("http://demo.guru99.com/V1/index.php");
		Thread.sleep(500);

		logger.info("Passa o id resgatado: " + uidtext);
		this.driver.findElement(By.name("uid")).sendKeys(uidtext);
		Thread.sleep(500);

		logger.info("Passa a senha resgatada: " + senhatext);
		this.driver.findElement(By.name("password")).sendKeys(senhatext);
		Thread.sleep(500);

		logger.info("Clicando no botao Login");
		this.driver.findElement(By.name("btnLogin")).click();

		logger.info("Fim da etapa 3 - Registro de Log");
		logger.info("\n");

		/*---------------------------------------------------*/

		logger.info("Etapa 4 - Logout");

		logger.info("Resgatando o elemento log out na tela");
		WebElement logout = this.driver.findElement(By.xpath("/html/body/div[3]/div/ul/li[10]/a"));

		// Resgatando a mensagem de logout
		String resposta = logout.getText();

		// imprimi a mensagem
		System.out.println(resposta);

		// Grava mensagem no Log
		logger.info("Resposta gravada no arquivo de Log");
		logger.info("Texto Retornado: " + resposta);

		// sair
		Thread.sleep(500);
		this.driver.get("http://demo.guru99.com/V1/html/Logout.php");

		logger.info("Fim da Etapa 4 - Registro no Log - The End");
		logger.info("\n");
		
		// Registra resultado do teste no Log
		logger.info("Resultado do Teste: " + resposta.equals("Log out"));
		
		logger.info("\n");
		logger.info("--------------------------------------------------");
		logger.info("\n");

		// Testando validacao (Verde e Vermelho)
		Assert.assertEquals("Log out", resposta);
		
		

	}

}
