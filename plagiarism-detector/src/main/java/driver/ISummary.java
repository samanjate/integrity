package driver;

import java.util.Set;

/**
 * This interface provides methods to deal with the summary generated by the algorithm.
 * @author darshan.panse
 *
 */
public interface ISummary {
	/**
	 * Get a set of student pairs that are suspected to have significant plagiarism
	 * @return a set of student pairs that are suspected to have significant plagiarism
	 */
	public Set<IStudentPair> getRedPairs();
	
	/**
	 * Add a student pair to the set containing pairs suspected to have significant plagiarism
	 * @param sp a student pair
	 */
	public void setRedPairs(IStudentPair sp);
	
	/**
	 * Get a set of student pairs that are suspected to have medium plagiarism
	 * @return a set of student pairs that are suspected to have medium plagiarism
	 */
	public Set<IStudentPair> getYellowPairs();
	
	/**
	 * Add a student pair to the set containing pairs suspected to have medium plagiarism
	 * @param sp a student pair
	 */
	public void setYellowPairs(IStudentPair sp);
	
	/**
	 * Get a set of student pairs that are suspected to have no/insignificant plagiarism
	 * @return a set of student pairs that are suspected to have no/insignificant plagiarism
	 */
	public Set<Integer> getGreenIds();
	
	/**
	 * Add a studentId to the set containing student Ids of students who are not believed to have cheated
	 * @param studentId the Id of a student
	 */
	public void setGreenIds(Integer studentId);
	
	/**
	 * This method returns false if the given studentId is present in redPairs or yellowPairs lists,
	 * else returns true.
	 * @param studentId
	 * @return boolean
	 */
	public boolean isSafe(Integer studentId);
}
