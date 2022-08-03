package a2_1901040151;

import java.util.Date;
import utils.AttrRef;
import utils.DOpt;
import utils.DomainConstraint;
import utils.NotPossibleException;
import utils.OptType;

/**
 * @overview employees are people who work in an organisation
 * @attributes id Integer firstName String givenName String lastName String
 *             email String address String phone String dob Date gender Gender
 * @object A typical Employee is c=<i, f, l, g, e, a, p, d, n>, where id(i),
 *         firstName(f), lastName(l), givenName(g), email(e), address(a),
 *         phone(p), dob(d), gender(n)
 * @abstract_properties mutable(id)=false /\ optional(id)=false /\ min(id)=100
 *                      /\ mutable(firstName)=true /\ optional(firstName)=false
 *                      /\ length(firstName) = 35 /\ mutable(lastName)=true /\
 *                      optional(lastName)=false /\ length(lastName) = 35 /\
 *                      mutable(givenName)=true /\ optional(givenName)=false /\
 *                      length(givenName) = 35 /\ mutable(email)=true /\
 *                      optional(email)=true /\ length(email) = 200 /\
 *                      mutable(address)=true /\ optional(address)=false /\
 *                      length(address) = 1500 /\ mutable(phone)=true /\
 *                      optional(phone)=false /\ length(phone) =20 /\
 *                      mutable(dob)=false /\ optional(dob)=false /\ min(dob)
 *                      =(1/1/1900) /\ mutable(gender)=false /\
 *                      optional(gender)=false
 * @author NguyenThiNhan_1901040151
 */
public class Employee {

	@DomainConstraint(type = "Integer", mutable = false, optional = false, min = 100)
	private int id;

	@DomainConstraint(type = "String", mutable = true, optional = false, length = 35)
	private String firstName;

	@DomainConstraint(type = "String", mutable = true, optional = false, length = 35)
	private String givenName;

	@DomainConstraint(type = "String", mutable = true, optional = false, length = 35)
	private String lastName;

	@DomainConstraint(type = "String", mutable = true, optional = true, length = 200)
	private String email;

	@DomainConstraint(type = "String", mutable = true, optional = false, length = 1500)
	private String address;

	@DomainConstraint(type = "String", mutable = true, optional = false, length = 20)
	private String phone;

	@DomainConstraint(type = "Date", mutable = false, optional = false)
	private Date dob;

	@DomainConstraint(type = "Gender", mutable = false, optional = false, min = 1/1/1900)
	private Gender gender;

	// constructor methods
	/**
	 * @effects
	 * 
	 *          <pre>
	 *          if id, firstName, givenNname, lastNmae, email, address, phone, dob,
	 *          gender are valid initialise this as <id, firstName, givenNname,
	 *          lastNmae, email, address, phone, dob, gender> else throws
	 *          NotPossibleException
	 * 
	 *          <pre/>
	 */
//@DOpt(type=OptType.Constructor)
	public Employee(@AttrRef("id") int id, @AttrRef("firstName") String firstName,
			@AttrRef("givenName") String givenName, @AttrRef("lastName") String lastName,
			@AttrRef("email") String email, @AttrRef("address") String address, @AttrRef("phone") String phone,
			@AttrRef("dob") Date dob, @AttrRef("gender") Gender gender) throws NotPossibleException {
		// if id, firstName, givenNname, lastName, email, address, phone, dob, gender
		// are valid

		if (!validateId(id)) {
			throw new NotPossibleException("Employee.init: Invalid id: " + id);
		}

		if (!validateFirstName(firstName)) {
			throw new NotPossibleException("Employee.init: Invalid firstName: " + firstName);
		}

		if (!validateGivenName(givenName)) {
			throw new NotPossibleException("Employee.init: Invalid givenName: " + givenName);
		}

		if (!validateLastName(lastName)) {
			throw new NotPossibleException("Employee.init: Invalid lastName: " + lastName);
		}

		if (!validateEmail(email)) {
			throw new NotPossibleException("Employee.init: Invalid email: " + email);
		}

		if (!validateAddress(address)) {
			throw new NotPossibleException("Employee.init: Invalid address: " + address);
		}

		if (!validatePhone(phone)) {
			throw new NotPossibleException("Employee.init: Invalid phone: " + phone);
		}

		if (!validateDob(dob)) {
			throw new NotPossibleException("Employee.init: Invalid firstName: " + dob);
		}

		if (!validateGender(gender)) {
			throw new NotPossibleException("Employee.init: Invalid firstName: " + gender);
		}
		// initialise this as <id, firstName, givenNname, lastNmae, email, address,
		// phone, dob, gender>

		this.id = id;
		this.firstName = firstName;
		this.givenName = givenName;
		this.lastName = lastName;
		this.email = email;
		this.address = address;
		this.phone = phone;
		this.dob = dob;
		this.gender = gender;
	}

	/**
	 * @effects
	 * 
	 *          <pre>
	 * if id is valid
	 * set this.id = id
	 * return true
	 * else
	 * return false
	 *          </pre>
	 */
	@DOpt(type = OptType.Mutator)
	@AttrRef("id")
	public boolean setId(int id) {
		if (validateId(id)) {
			this.id = id;
			return true;
		} else {
			return false;
		}
	}

	/**
	 * @effects
	 * 
	 *          <pre>
	 * if firstName is valid
	 * set this.firstName=firstName
	 * return true
	 * else
	 * return false
	 *          </pre>
	 */
	@DOpt(type = OptType.Mutator)
	@AttrRef("firstName")
	public boolean setFirstName(String firstName) {
		if (validateFirstName(firstName)) {
			this.firstName = firstName;
			return true;
		} else {
			return false;
		}
	}

	/**
	 * @effects
	 * 
	 *          <pre>
	 * if lastName is valid
	 * set this.lastName=lastName
	 * return true
	 * else
	 * return false
	 *          </pre>
	 */
	@DOpt(type = OptType.Mutator)
	@AttrRef("lastName")
	public boolean setLastName(String lastName) {
		if (validateLastName(lastName)) {
			this.lastName = lastName;
			return true;
		} else {
			return false;
		}
	}

	/**
	 * @effects
	 * 
	 *          <pre>
	 * if givenName is valid
	 * set this.givenName=givenName
	 * return true
	 * else
	 * return false
	 *          </pre>
	 */
	@DOpt(type = OptType.Mutator)
	@AttrRef("givenName")
	public boolean setGivenName(String givenName) {
		if (validateGivenName(givenName)) {
			this.givenName = givenName;
			return true;
		} else {
			return false;
		}
	}

	/**
	 * @effects
	 * 
	 *          <pre>
	 * if email is valid
	 * set this.email=email
	 * return true
	 * else
	 * return false
	 *          </pre>
	 */
	@DOpt(type = OptType.Mutator)
	@AttrRef("email")
	public boolean setEmail(String email) {
		if (validateEmail(email)) {
			this.email = email;
			return true;
		} else {
			return false;
		}
	}

	/**
	 * @effects
	 * 
	 *          <pre>
	 * if address is valid
	 * set this.address=address
	 * return true
	 * else
	 * return false
	 *          </pre>
	 */
	@DOpt(type = OptType.Mutator)
	@AttrRef("address")
	public boolean setAddress(String address) {
		if (validateAddress(address)) {
			this.address = address;
			return true;
		} else {
			return false;
		}
	}

	/**
	 * @effects
	 * 
	 *          <pre>
	 * if phone is valid
	 * set this.phone=phone
	 * return true
	 * else
	 * return false
	 *          </pre>
	 */
	@DOpt(type = OptType.Mutator)
	@AttrRef("phone")
	public boolean setPhone(String phone) {
		if (validatePhone(phone)) {
			this.phone = phone;
			return true;
		} else {
			return false;
		}
	}

	/**
	 * @effects
	 * 
	 *          <pre>
	 * if dob is valid
	 * set this.dob=dob
	 * return true
	 * else
	 * return false
	 *          </pre>
	 */
	@DOpt(type = OptType.Mutator)
	@AttrRef("dob")
	public boolean setDob(Date dob) {
		if (validateDob(dob)) {
			this.dob = dob;
			return true;
		} else {
			return false;
		}
	}

	/**
	 * @effects
	 * 
	 *          <pre>
	 * if gender is valid
	 * set this.gender=gender
	 * return true
	 * else
	 * return false
	 *          </pre>
	 */
	@DOpt(type = OptType.Mutator)
	@AttrRef("gender")
	public boolean setGender(Gender gender) {
		if (validateGender(gender)) {
			this.gender = gender;
			return true;
		} else {
			return false;
		}
	}

	/**
	 * @effects return <tt>id</tt>
	 */
	@DOpt(type = OptType.Observer)
	@AttrRef("id")
	public int getId() {
		return id;
	}

	@DOpt(type = OptType.Observer)
	@AttrRef("firstName")
	public String getFirstName() {
		return firstName;
	}

	@DOpt(type = OptType.Observer)
	@AttrRef("givenName")
	public String getGivenName() {
		return givenName;
	}

	@DOpt(type = OptType.Observer)
	@AttrRef("lastName")
	public String getLastName() {
		return lastName;
	}

	@DOpt(type = OptType.Observer)
	@AttrRef("email")
	public String getEmail() {
		return email;
	}

	@DOpt(type = OptType.Observer)
	@AttrRef("address")
	public String getAddress() {
		return address;
	}

	@DOpt(type = OptType.Observer)
	@AttrRef("phone")
	public String getPhone() {
		return phone;
	}

	@DOpt(type = OptType.Observer)
	@AttrRef("dob")
	public Date getDob() {
		return dob;
	}

	@DOpt(type = OptType.Observer)
	@AttrRef("gender")
	public Gender getGender() {
		return gender;
	}

	/**
	 * @effects
	 * 
	 *          <pre>
	 * if id is valid
	 * return true
	 * else
	 * return false
	 *          </pre>
	 */
	private boolean validateId(int id) {
		return id >= 100;
	}

	/**
	 * @effects
	 * 
	 *          <pre>
	 * if firstName is valid
	 * return true
	 * else
	 * return false
	 *          </pre>
	 */
	private boolean validateFirstName(String firstName) {
		return (firstName != null && firstName.length() > 0 && firstName.length() <= 35);
	}

	private boolean validateLastName(String lastName) {
		return (lastName != null && lastName.length() > 0 && lastName.length() <= 35);
	}

	private boolean validateGivenName(String givenName) {
		return (givenName != null && givenName.length() > 0 && givenName.length() <= 35);
	}

	private boolean validateEmail(String email) {
		return (email != null && email.length() > 0 && email.length() <= 200);
	}

	private boolean validateAddress(String address) {
		return (address != null && address.length() > 0 && address.length() <= 1500);
	}

	private boolean validatePhone(String phone) {
		return (phone != null && phone.length() > 0 && phone.length() <= 20);
	}

	private boolean validateDob(Date dob) {
		return dob.before(new Date(1900, 1, 1));
	}

	private boolean validateGender(Gender gender) {
		return gender != null;
	}

	@Override
	public String toString() {
		return String.format("Employee:<%d,%s>", id, firstName, lastName, givenName, email, address, phone, dob,
				gender);
	}

	@Override
	public boolean equals(Object o) {
		if (o == null || !(o instanceof Employee)) {
			return false;
		} else {
			Employee other = (Employee) o;
			return id == other.getId() && firstName.equals(other.getFirstName())
					&& givenName.equals(other.getGivenName()) && lastName.equals(other.getLastName())
					&& email.equals(other.getEmail()) && address.equals(other.getAddress())
					&& phone.equals(other.getPhone()) && dob.equals(other.getDob()) && gender.equals(other.getGender());
		}
	}

	/**
	 * @effects
	 * 
	 *          <pre>
	 * if this satisfies abstract properties
	 * return true
	* else
	* return false
	 *          </pre>
	 */
	public boolean repOK() {
		return validateId(id) && validateFirstName(firstName) && validateGivenName(givenName)
				&& validateLastName(lastName) && validateEmail(email) && validatePhone(phone)
				&& validateAddress(address) && validateDob(dob) && validateGender(gender);
	}
}
