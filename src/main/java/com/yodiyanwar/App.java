package com.yodiyanwar;

import com.yodiyanwar.dao.PersonDAOImpl;
import com.yodiyanwar.dao.PersonDAO;
import com.yodiyanwar.model.Person;
import com.yodiyanwar.util.HibernateUtil;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import org.hibernate.HibernateException;
import org.hibernate.Transaction;

public class App {
    public static void main( String[] args ){

    	String snik;
        Integer nik;
        String nama;
        String alamat;
    	BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

    	PersonDAO operasi = new PersonDAOImpl();
    	Person person = null;

    	int pil = 10;
    	do{
	    	try{
	    		show("\n|===================================|");
        show("|========= SIMPLE PROGRAM ==========|");
        show("| -------- HIBERNATE CRUD --------- |");
        show("|===================================|");
        show("             Yodi Yanwar             \n");

		    	show("1. List Persons");
		    	show("2. Add Person");
		    	show("3. Edit Person");
		    	show("4. Delete Person");
		    	show("5. get Person");
		    	show("0. Exit");

		    	showw("Your Choice : "); String pils = in.readLine();
                        pil = Integer.parseInt(pils);
		    	
                        if(pil == 1){
                            operasi.listPersons();
                        } else if(pil == 2){
                        	show("\n|===================================|");
        		show("|========== ADD PERSON ===========|");
        		show("| -------- HIBERNATE CRUD --------- |");
        		show("|===================================|");
       			show("             Yodi Yanwar             \n");

                            showw("Input NIK Person     : ");  snik = in.readLine();
                           	nik = Integer.parseInt(snik);
                            showw("Input Person Name    : ");  nama = in.readLine();
                            showw("Input Person Address : ");  alamat = in.readLine();
                            
                            person = new Person();
                            person.setNik(nik);
                            person.setNama(nama);
                            person.setAlamat(alamat);
                            
                            operasi.save(person);
                        } else if(pil == 3){
                            showw("Input NIK Number you wan't to edit   : "); snik = in.readLine();
                            	nik = Integer.parseInt(snik);
                            showw("Input new Name                       : "); nama = in.readLine();
                            showw("Input new Address                    : "); alamat = in.readLine();
                            
                            person = new Person();
                            person.setNik(nik);
                            person.setNama(nama);
                            person.setAlamat(alamat);
                            
                            operasi.update(person, nik);
                        } else if(pil == 4){
                            showw("Input NIK Number you wan't to delete   : "); snik = in.readLine();
                            	nik = Integer.parseInt(snik);
                            
                            operasi.delete(nik);
                        } else if(pil == 5){
                            showw("Input NIK Number you wan't to see   : "); snik = in.readLine();
                            	nik = Integer.parseInt(snik);
                            
                            operasi.getPerson(nik);
                        } else if(pil == 0) {
                            show("Exitting...\nBye ");
                            System.exit(0);
                        }  /*else{
                            show("Silakan Masukan input sesuai dengan pilihan diatas !");
                        }
                        */

		    } catch(NumberFormatException nf){
		    	show("Terjadi Kesalahan !\n"+nf.getMessage());
		    	show("==> Input Harus Angka ! <==");
		    } catch(HibernateException he){
		    	show("Terjadi HibernateException !\n"+he.getMessage());
		    	he.printStackTrace();
		    } catch(IOException e){
		    	show("Terjadi IOException !\n"+e.getMessage());
		    	e.printStackTrace();
		    }

		} while(pil != 0);
    }

    private static void show(String pesan){
    	System.out.println(pesan);
    }
    private static void showw(String pesan){
    	System.out.print(pesan);
    }
}
