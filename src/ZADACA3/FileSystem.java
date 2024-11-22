package ZADACA3;

public class FileSystem {
    private Folder rootDirectory;

    FileSystem(){
        this.rootDirectory = new Folder("root");
    }
    public void addFile (IFile file) throws FileNameExistsException {
        rootDirectory.addFile(file);
    }
    public long findLargestFile (){
        return rootDirectory.findLargestFile();
    }

    public void sortBySize(){
        rootDirectory.sortBySize();
    }

    @Override
    public String toString() {
        return rootDirectory.getFileInfo(0);
    }
}
