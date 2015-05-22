package alex;

/**
 * mnikitin on 5/22/15
 * <p>
 * This class represents information about patient account
 */
public class PatientAccount {

	/**
	 * Unique patient ID
	 */
	private int passportId;
	/**
	 * Patient name
	 */
	private String name;
	/**
	 * Type of insurance current patient has
	 */
	private int insuranceType;

	public PatientAccount(int passportId, String name, int insuranceType) {
		this.passportId = passportId;
		this.name = name;
		this.insuranceType = insuranceType;
	}

	public int getPassportId() {
		return passportId;
	}

	public void setPassportId(int passportId) {
		this.passportId = passportId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getInsuranceType() {
		return insuranceType;
	}

	public void setInsuranceType(int insuranceType) {
		this.insuranceType = insuranceType;
	}
}
