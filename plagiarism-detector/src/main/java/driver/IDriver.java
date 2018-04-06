package driver;

import algorithms.Algorithm;

import java.io.File;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * This interface provides a contract for the driver of the application.
 * @author darshan.panse
 *
 */
public interface IDriver {
	/**
	 * Setter for repoPaths.
	 * @param repoPaths List<String>
	 */
	public void setRepoPaths(List<String> repoPaths);
	
	/**
	 * Setter for hwDir.
	 * @param hwDir String
	 */
	public void setHWDir(String hwDir);
	
	/**
	 * Gets the student data from the excel file provided by prof or TA
	 * and stores it as a map in the studentMap.
	 * @param xlsxFile File
	 * @return errorMessage String
	 */
	public String getStudentData(File xlsxFile);
	
	/**
	 * Constructs the path to get the c files from the dir recursively.
	 * @param repoPath String
	 * @return String
	 */
	public String constructPath(String repoPath);
	
	/**
	 * Gets the c files recursively from all the directories.
	 * @return errorMessage String
	 */
	public String getCodeFiles();

	/**
	 * This method compares the similarity between the homework c files of two students
	 * and generates the summary. Also it returns false if the two students get paired
	 * for plagiarism (both high and medium probability).
	 * @param fileList1 Collection<File>
	 * @param fileList2 Collection<File>
	 * @param sp StudentPair
	 */
	public void computeSimilarityScore(Collection<File> fileList1, Collection<File> fileList2, IStudentPair sp);
	
	/**
	 * This method runs the algorithm on the homework c files of all the 
	 * selected student-repos and generates the Summary.
	 */
	public void generateSummary();
	
	/**
	 * Employs a comparison strategy and compares all files of all students.
	 * @param repoPaths List<String>
	 * @param hwDir String
	 * @return errorMessage String
	 */
	public String checkForPlagiarism(List<String> repoPaths, String hwDir, Algorithm algo);
	
	/**
	 * This methods returns the Summary generated by the method generateSummary()
	 * @return Summary
	 */
	public ISummary viewSummary();
	
	/**
	 * This method compares all the HW files of two students and returns the result
	 * of the plagiarism algorithm along with the snippets data.
	 * @param fileList1 List<File>
	 * @param fileList2 List<File>
	 * @return List<SnippetPair>
	 */
	public List<IFilePair> compareFilesForResult(Collection<File> fileList1, Collection<File> fileList2);
	
	/**
	 * This method generates the snippet data for the HW files of two students 
	 * and returns the snippet data.
	 * @param student1Id Integer
	 * @param student2Id Integer
	 * @return codeSnippet CodeSnippet
	 */
	public ICodeSnippets generateSnippet(Integer student1Id, Integer student2Id);
	
	/**
	 * Getter for studentHWMap. This method is made for testing purposes.
	 * @return studentHWMap Map<Integer, Collection<File>>
	 */
	public Map<Integer, Collection<File>> getStudentHWMap();
	
	/**
	 * This method returns the name of the student given the id of the student.
	 * @param studentId Integer
	 * @return String
	 * @param studentId
	 * @return String
	 */
	public String getNameById(Integer studentId);

	/**
	 * Get the email of the student by his/her Id
	 * @param studentId the Id of the student
	 * @return the email of the student
	 */
	public String getEmailById(Integer studentId);
	
	/**
	 * This method resets the state of the application and clears all the parameters.
	 * 
	 */
	public void resetState();
}
