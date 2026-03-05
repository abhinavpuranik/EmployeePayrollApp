/* @author Developer
 * @version 5.0
 * Dashboard interface
 * 
 */

package com.seveneleven.dashboard;

import java.util.ArrayList;
import com.seveneleven.model.Payslip;
import com.seveneleven.registration.Employee;

public interface Dashboard {

    void display(ArrayList<Payslip> payslips, Employee employee);

}