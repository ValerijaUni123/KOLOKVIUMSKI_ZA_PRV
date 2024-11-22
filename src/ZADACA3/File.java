package ZADACA3;

public class File implements IFile{
    private String name;
    private long size;

    public File(String name, long size) {
        this.name = name;
        this.size = size;
    }

    @Override
    public String getFileName() {
        return name;
    }

    @Override
    public long getFileSize() {
        return size;
    }

    @Override
    public String getFileInfo(int indent) {
        StringBuilder stringBuilder = new StringBuilder();
        for(int i = 0; i < indent; i++){
            stringBuilder.append("\t");
        }
        stringBuilder.append(String.format("File name: %10s File size: %10d%n",
                getFileName(), getFileSize()));
        return stringBuilder.toString();
    }

    @Override
    public void sortBySize() {
        //ne pravi nisto
    }

    @Override
    public long findLargestFile() {
        return size;
    }
}
