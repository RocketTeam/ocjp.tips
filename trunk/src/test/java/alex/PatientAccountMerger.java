package alex;

import java.util.*;

/**
 * mnikitin on 5/22/15.
 *
 * This demo class merges two different lists of patient accounts according to their insurance type.
 *
 */
public class PatientAccountMerger {

	/**
	 * OMS insurance type
	 * */
	public static final int INSURANCE_TYPE_OMS = 0;

	/**
	 * DMS insurance type
	 * */
	public static final int INSURANCE_TYPE_DMS = 1;

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

		PatientAccountMerger accountMerger = new PatientAccountMerger();
		List<PatientAccount> mergedAccounts = accountMerger.mergePatientAccounts(omsAccounts, dmsAccounts);

		for (PatientAccount account : mergedAccounts) {
			System.out.println("[ ID: " + account.getPassportId() + " | Name: " + account.getName() + " | Type: " + account.getInsuranceType() + " ]");
		}
	}

	/**
	 * This method merges oms-specific accounts with dms-specific accounts with respect to the rule:
	 * if patient has both DMS and OMS accounts - DMS account should be added to result
	 */
	public List<PatientAccount> mergePatientAccounts(List<PatientAccount> omsAccounts, List<PatientAccount> dmsAccounts) {
		if (omsAccounts == null) {
			throw new RuntimeException("Failed to merge accounts. OMS accounts are missing.");
		}

		if (dmsAccounts == null) {
			throw new RuntimeException("Failed to merge accounts. DMS accounts are missing.");
		}

		Set<Integer> passportIds = new HashSet<>();

		List<PatientAccount> mergedAccounts = new ArrayList<>();
		for (PatientAccount patientAccount : dmsAccounts) {
			passportIds.add(patientAccount.getPassportId());
			mergedAccounts.add(patientAccount);
		}

		for (PatientAccount currentAccount : omsAccounts) {
			if (passportIds.contains(currentAccount.getPassportId())) {
				continue;
			}

			mergedAccounts.add(currentAccount);
		}

		removeAllWhoIsMr(mergedAccounts);

		return mergedAccounts;
	}

	private static void removeAllWhoIsMr(List<PatientAccount> mergedAccounts) {
		Iterator<PatientAccount> iterator = mergedAccounts.iterator();
		while (iterator.hasNext()) {
			PatientAccount nextAccount = iterator.next();
			if (nextAccount.getName().startsWith("Mr.")) {
				iterator.remove();
			}
		}
	}
}
