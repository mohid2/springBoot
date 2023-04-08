package com.example.ejerccio1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Ejerccio1Application {

	public static void main(String[] args) {
		ApplicationContext context=SpringApplication.run(Ejerccio1Application.class, args);
		LaptopRepository repository=context.getBean(LaptopRepository.class);
		Laptop hp1=new Laptop(null,"HP","ProBook",4,128);
		Laptop dell=new Laptop(null,"Dell", "Latitude 5490",8,228);
		Laptop lenovo=new Laptop(null,"Lenovo", "ThinkPad X1 Carbon",4,500);
		Laptop hp2=new Laptop(null,"HP", "Spectre x360",4,128);

		repository.save(hp1);
		repository.save(dell);
		repository.save(lenovo);
		repository.save(hp2);

	}

}
