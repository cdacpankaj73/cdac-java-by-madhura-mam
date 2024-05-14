package com.ovs.tester;

import java.sql.Date;
import java.util.Scanner;

import com.ovs.Dao.OvsDaoImpl;
import com.ovs.entities.User;

public class OvsApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try(Scanner sc=new Scanner(System.in))
		{
			int ch;
			OvsDaoImpl voterDao=new OvsDaoImpl();
			System.out.println("-----------------Welcome to on Pankaj online  voting system---------------------");
			do
			{
				System.out.println("-----------------------------------------------------------------------------");
				System.out.println("1.Register voter \n2.Voter login \n3.Admin login \n4.change Password \n5.Exit");
				System.out.println("----------------------------------------------------------------------------- \nEnter your choice:");
				ch=sc.nextInt();
				try
				{
					switch(ch)
					{
					case 1:
						System.out.println("Enter Voter's details - firstName,lastName,email,password,dob");
						User user=new User(sc.next(),sc.next(),sc.next(),sc.next(),Date.valueOf(sc.next()));
						System.out.println(voterDao.voterRegistration(user));
						break;
					case 2:
						System.out.println("Enter Your Email and password for login:");
						User voter=voterDao.voterLogin(sc.next(),sc.next());
						if(voter==null)
						{
							System.out.println("voter login failed.............!");
						}
						else
						{
							System.out.println("voter login successfully.............");
							do 
							{
								System.out.println("\n--------Voter Menu----------\n1.Register your vote 2.logout");
								int vch=sc.nextInt();
								switch(vch)
								{
								case 1:
									voterDao.listCandidates();
									System.out.println("enter the id of candidate:");
									System.out.println(voterDao.registerVote(voter.getUserId(),sc.nextInt(),voter.getFirstName(),voter.getLastName()));
									break;
								case 2:
									System.out.println("Voter logout Successfully");
									break;
								default:
									System.out.println("you enter wrong choice");
								}
							}
							while(ch!=2);
						}
						break;
					case 3:
						System.out.println("Enter Your Email and password for login:");
						User admin=voterDao.AdminLogin(sc.next(),sc.next());
						if(admin==null)
						{
							System.out.println("login Failed................");
						}
						else
						{
							System.out.println("Admin login Successfully................");
							int ach;
							do 
							{
								System.out.println("\n-----------------Admin Menu-------------\n1.view top 2 Candidate \n2.vote analysis by political parties \n3.Delete voter \n4.Logout  \nEnter your choice:");
								ach=sc.nextInt();
							
								switch(ach)
								{
								case 1:
									voterDao.viewTWoTopCandidate();
									break;
								case 2:
									voterDao.viewReportByPartywise();
									break;
								case 3:
									System.out.println("Enter the voter id:");
									System.out.println(voterDao.deleteVoter(sc.nextInt()));
									break;
								case 4:
									System.out.println("Admin logout successfully......");
									break;
								default:
									System.out.println("you enter the wrong choice......");
								}
							}
							while(ach!=4);
						}
						break;
					case 4:
						System.out.println("Enter the email password and new password:");
						System.out.println(voterDao.passswordUpdation(sc.next(),sc.next(),sc.next()));
						break;
					case 5:
						System.out.println("thank you.............");
						break;
					default:
						System.out.println("You enter the wrong choice...........");
					}
				}
				catch(Exception e)
				{
					System.out.println(e.getMessage());
					
				}
			}while(ch!=5);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}

}

