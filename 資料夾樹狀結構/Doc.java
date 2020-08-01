
public class Doc {
	private int docObjKey = 0;
	private String wbsLocation = null;

	public Doc() {
		super();
	}

	public Doc(int docObjKey, String wbsLocation) {
		super();
		this.docObjKey = docObjKey;
		this.wbsLocation = wbsLocation;
	}

	public int getDocObjKey() {
		return docObjKey;
	}

	public void setDocObjKey(int docObjKey) {
		this.docObjKey = docObjKey;
	}

	public String getWBSLocation() {
		return wbsLocation;
	}

	public void setWBSLocation(String wbsLocation) {
		this.wbsLocation = wbsLocation;
	}
}
