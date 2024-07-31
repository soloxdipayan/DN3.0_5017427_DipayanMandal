public class Test2 {
    public static void main(String args[]) {
        // test word document factory
        DocumentFactory wordfact = new WordDocumentFactory();
        Document wordDoc = wordfact.creatDocument();
        wordDoc.open();

        // test pdf document factory
        DocumentFactory pdffact = new PdfDocumentFactory();
        Document pdfdoc = pdffact.creatDocument();
        pdfdoc.open();

        // test excel document factory
        DocumentFactory excelfact = new ExcelDocuemntFactory();
        Document exceldoc = excelfact.creatDocument();
        exceldoc.open();
    }

}
