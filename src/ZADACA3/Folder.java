package ZADACA3;

import java.util.ArrayList;
import java.util.List;

public class Folder implements IFile{
    private String name;
    private List<IFile> files;

    public Folder(String name) {
        this.name = name;
        this.files = new ArrayList<>();
    }
    @Override
    public String getFileName() {
        return name;
    }

    @Override
    public long getFileSize() {
        return files.stream().mapToLong(IFile::getFileSize).sum();
    }

    @Override
    public String getFileInfo(int indent) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < indent; i++) {
            stringBuilder.append("\t");
        }
        stringBuilder.append(String.format("Folder name: %10s Folder size: %10d%n", getFileName(), getFileSize()));
        for(IFile file : files) {
            stringBuilder.append(file.getFileInfo(indent +1));
        }

        return stringBuilder.toString();
    }

    @Override
    public void sortBySize() {
        files.sort(IFile::compareTo);
        for(IFile file : files) {
            file.sortBySize();
        }
    }

    @Override
    public long findLargestFile() {
        return files.stream().mapToLong(IFile::findLargestFile).max().orElse(0);
    }

    public boolean duplicatesCheck(IFile file){
        for(IFile f : files) {
            if(f.getFileName().equals(file.getFileName())) {
                return true;            }
        }
        return false;
    }

    void addFile(IFile file) throws FileNameExistsException {
        if(duplicatesCheck(file)){
            throw new FileNameExistsException(file.getFileName(), this.name);
        }
        files.add(file);
    }

}
