public class NoteBook {
    String brandNoteBook;
    String modelNoteBook;
    String colorNoteBook;
    Integer capacityHardDisk;
    Integer ramNoteBook;
    String osNoteBook;

    public NoteBook(String brandNoteBook, String modelNoteBook, String colorNoteBook, Integer capacityHardDisk,
            Integer ramNoteBook, String osNoteBook) {
        this.brandNoteBook = brandNoteBook;
        this.modelNoteBook = modelNoteBook;
        this.colorNoteBook = colorNoteBook;
        this.capacityHardDisk = capacityHardDisk;
        this.ramNoteBook = ramNoteBook;
        this.osNoteBook = osNoteBook;
    }

    @Override
    public String toString() {
        return this.brandNoteBook + "/" + this.modelNoteBook + "/" +
                this.colorNoteBook + "/" + this.capacityHardDisk + "/" +
                this.ramNoteBook + "/" + this.osNoteBook + "/";
    }

}
