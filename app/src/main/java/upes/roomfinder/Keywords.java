package upes.roomfinder;

public class Keywords {
	//I know this is super gross but its needed.
	public static final String[] ninethblock = {"NINE 005", "NINE 007", "NINE 009", "NINE 012"};
	public static final String[] tenthblock = {"TENTH 001", "TENTH 003", "TENTH 009", "TENTH 103"};
	public static final String[] eleventhblock = {"ELEVENTH 002", "ELEVENTH 004", "ELEVENTH 006", "ELEVENTH 013"};

	public static final String[] blank = {""};//should actually serve a purpose not actually garbage

	public static final String currentTerm = "upes.txt";
	
	//essential
	public static final String[] regex = {"UPES	", "ENGR", "LITR", "NR"};

//	//stuff that used to be in the regex. Dont need it anymore, will chop once I'm sure
//	String[] specificProblems = {"COOP EDUCATION 1:", "COOP EDUCATION 2:", "VISUALIZATION 3:", "CAD 2:", "VISUAL PERCEPTION OF THE CITY:",
//			"MYTH AMERICA:", "VISUALIZATION 2: ADV PRSPECTIV", "CAD 1: SURSURFACE MODELING\tT", "DESIGN PERSP: TOPICS IN HISTOR"};

	static String[] mondayCases = {"	M	","	MT", "	MW", "	MR", "	MF"};

	static String[] tuesdayCases = {"	MT", "	T	",  "	TW", "TR	","TF	"};
	static String[] wednesdayCases = {"	W	", "	MW", "	MTW", "	TW", "	WR", "	WRF	"};
	static String[] thursdayCases = {"R	", "RF"};
	static String[] fridayCases = {"F	"}; //this will pick up last names that end with F well see how big that is.
	public static  String[] getKeywords(){
		return regex;
	}
	public static String[] getMondayCases(){
		return mondayCases;
	}
	public static String[] getTuesdayCases() {
		return tuesdayCases;
	}
	public static String[] getWednesdayCases() {
		return wednesdayCases;
	}
	public static String[] getThursdayCases() {
		return thursdayCases;
	}
	public static String[] getFridayCases() {
		return fridayCases;
	}
}
