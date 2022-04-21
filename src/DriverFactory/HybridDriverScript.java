package DriverFactory;

import org.testng.Reporter;
import org.testng.annotations.Test;

import CommonFunctions.FunctionLibrary;
import Constant.PBAppUtil;
import Utilities.ExcelFileUtil;

public class HybridDriverScript extends PBAppUtil
{
	String inputpath = "C:\\Users\\CANVAS\\eclipse-workspace\\DDT_FrameWork\\TestInput\\HybridTest.xlsx";
	String outputpath = "C:\\Users\\CANVAS\\eclipse-workspace\\DDT_FrameWork\\TestOutput\\HybridResults.xlsx";
	String TCSheet = "TestCases";
	String TSSheet = "TestSteps";
	@Test
	public void startTest() throws Throwable
	{
		boolean res = false;
		String tcres = "";
		//create object for excel file util
		ExcelFileUtil xl = new ExcelFileUtil(inputpath);
		int TCCount =xl.rowCount(TCSheet);
		int TSCount =xl.rowCount(TSSheet);
		Reporter.log(TCCount+"  "+TSCount,true);
		for(int i=1;i<=TCCount;i++)
		{
			String executemode =xl.getCellData(TCSheet,i,2);
			if(executemode.equalsIgnoreCase("Y"))
			{
				// read tcid cell
				String tcid =xl.getCellData(TCSheet, i, 0);
				if(int j=1;j<=TSCount;j++)
				{
					//read tsid cell
					String tsid =xl.getCellData(TSSheet, j, 0);
					if(tcid.equalsIgnoreCase(tsid))
					{
						//read keyword cell
						String keyword =xl.getCellData(TSSheet,j,4);
						if(keyword.equalsIgnoreCase("AdminLogin"))
						{
							String username =xl.getCellData(TSSheet, j, 5);
							String password =xl.getCellData(TSSheet, j, 6);
							res = FunctionLibrary.verifyLogin(username, password);
						}
						else if(keyword.equalsIgnoreCase("NewBranchCreation"))
						{
							String branchname =xl.getCellData(TSSheet,j,5);
							String Address1 =xl.getCellData(TSSheet,j,6);
							String Address2 =xl.getCellData(TSSheet,j,7);
							String Address3 =xl.getCellData(TSSheet,j,8);
							String Area =xl.getCellData(TSSheet,j,9);
							String zipcode =xl.getCellData(TSSheet,j,10);
							String country =xl.getCellData(TSSheet,j,11);
							String state =xl.getCellData(TSSheet,j,12);
							String city =xl.getCellData(TSSheet,j,13);
							FunctionLibrary.clickBranches();
							res =FunctionLibrary.verifyNewBranch(branchname, Address1, Address2, Address3, Area, zipcode, country, state, city);
					
							}
						else if(keyword.equalsIgnoreCase("UpdateBranch"))
						{
							String branchname =xl.getCellData(TSSheet,j,5);
							String Address =xl.getCellData(TSSheet,j,6);
							String zipcode =xl.getCellData(TSSheet,j,10);
							FunctionLibrary.clickBranches();
							res =FunctionLibrary.verifyBranchUpdate(branchname, Address, zipcode);
							
						}
						else if(keyword.equalsIgnoreCase("AdminLogout"))
						{
							res =FunctionLibrary.verifyLogout();
						}
						String tsres = "";
						if(res)
						{
							tsres="pass";
							xl.setCellData(TSSheet,j,3,tsres,outputpath);
						}
						else
						{
							tsres="fail";
							xl.setCellData(TSSheet,j,3,"tsres",outputpath);
						}
						tcres=tsres;
					}
				}
				xl.setCellData(TCSheet,i,3,tcres,outputpath);
			}
		}
		}

	else
	       {
	
				// write as blocked for N flag
				xl.setCellData(TCSheet,i,3,"blocked",outputpath);
	       }
			
			
       }
		
	}
	
	
	


