package testngprsctice;

import org.testng.annotations.Test;

public class Groups {
	@Test(dependsOnGroups = "smoke") 
	public void grp1() {
		System.out.println("grp1");
	}
	@Test(groups = "smoke")
	public void grp2() {
		System.out.println("grp2");
	}
	@Test(groups = { "smoke", ""})
	public void grp3() {
		System.out.println("grp3");
	}
}
