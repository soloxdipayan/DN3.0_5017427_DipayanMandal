public class PdfDocumentFactory  extends DocumentFactory {
    public Document creatDocument() {
        return new PdfDocument();
    }
}