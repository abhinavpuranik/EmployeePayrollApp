/* @author Developer
 * @version 5.0
 * 
 */

package com.seveneleven.dashboard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

import com.seveneleven.model.Payslip;
import com.seveneleven.registration.Employee;

public class EmployeeDashboard implements Dashboard {

    public void display(ArrayList<Payslip> payslips, Employee employee) {

        System.out.println("\n=== EMPLOYEE DASHBOARD ===");
        System.out.println("Welcome, " + employee.getName());

        System.out.println("Dashboard Type: " + this.getClass().getName());

        // Sort payslips descending by netPay
        Collections.sort(payslips, new Comparator<Payslip>() {

            public int compare(Payslip p1, Payslip p2) {
                return (int)(p2.getNetPay() - p1.getNetPay());
            }

        });

        System.out.println("\nRecent Payslips (Top 3):");

        int count = 0;
        Iterator<Payslip> it = payslips.iterator();

        while(it.hasNext() && count < 3) {

            Payslip p = it.next();

            System.out.println(p.getMonth() + " : " + p.getNetPay());

            count++;
        }

        // Calculate YTD earnings
        double total = 0;

        Iterator<Payslip> it2 = payslips.iterator();

        while(it2.hasNext()) {

            Payslip p = it2.next();

            total += p.getNetPay();
        }

        System.out.println("\nYear-To-Date Earnings: " + total);
    }
}