package alex;

import java.util.ArrayList;
import java.util.List;

/**
 * mnikitin on 5/22/15.
 *
 * This demo class merges two different lists of patient accounts according to their insurance type.
 */
public class PatientAccountMerger {

	/**
	 * OMS insurance type
	 * */
	private static final int INSURANCE_TYPE_OMS = 0;

	/**
	 * DMS insurance type
	 * */
	private static final int INSURANCE_TYPE_DMS = 1;

	public static void main(String[] args) {
		List<PatientAccount> omsAccounts = new ArrayList<>();
		omsAccounts.add(new PatientAccount(0, "Sponge Bob", INSURANCE_TYPE_OMS));
		omsAccounts.add(new PatientAccount(1, "Patrick", INSURANCE_TYPE_OMS));
		omsAccounts.add(new PatientAccount(2, "Squidward", INSURANCE_TYPE_OMS));
		omsAccounts.add(new PatientAccount(3, "Plankton", INSURANCE_TYPE_OMS));
		omsAccounts.add(new PatientAccount(4, "Mr. Anybody", INSURANCE_TYPE_OMS));

		List<PatientAccount> dmsAccounts = new ArrayList<>();
		dmsAccounts.add(new PatientAccount(5, "Mr. Krabs", INSURANCE_TYPE_DMS));
		dmsAccounts.add(new PatientAccount(2, "Squidward", INSURANCE_TYPE_DMS));
		dmsAccounts.add(new PatientAccount(6, "Mr. Anybody", INSURANCE_TYPE_DMS));

		List<PatientAccount> mergedAccounts = mergePatientAccounts(omsAccounts, dmsAccounts);
		for (int i = 0; i < mergedAccounts.size(); i++) {
			PatientAccount account = mergedAccounts.get(i);
			System.out.println("[ ID: " + account.getPassportId() + " | Name: " + account.getName() + " | Type: " + account.getInsuranceType() + " ]");
		}
	}

	/**
	 * This method merges oms-specific accounts with dms-specific accounts with respect to the rule:
	 * if patient has both DMS and OMS accounts - DMS account should be added to result
	 * */
	public static List<PatientAccount> mergePatientAccounts(List<PatientAccount> omsAccounts, List<PatientAccount> dmsAccounts) {
		return null;
	}
}
