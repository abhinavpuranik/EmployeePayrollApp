/* @author Developer
 * @version 5.0
 * 
 */

package com.seveneleven.dashboard;

import java.util.ArrayList;
import java.util.Iterator;

import com.seveneleven.model.Payslip;
import com.seveneleven.registration.Employee;

public class ManagerDashboard implements Dashboard {

    public void display(ArrayList<Payslip> payslips, Employee employee) {

        System.out.println("\n=== MANAGER DASHBOARD ===");
        System.out.println("Manager: " + employee.getName());

        System.out.println("Dashboard Type: " + this.getClass().getName());

        double total = 0;

        Iterator<Payslip> it = payslips.iterator();

        while(it.hasNext()) {

            Payslip p = it.next();

            total += p.getNetPay();
        }

        System.out.println("\nTeam Total YTD Earnings: " + total);
    }
}