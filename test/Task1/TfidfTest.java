package Task1;

import org.junit.jupiter.api.*;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class TfidfTest {

    private HashTable doc1;
    private HashTable doc2;
    private ArrayList<HashTable> allDocs;
    private Tfidf tfidf;

    @BeforeEach
    void setUp() {
        doc1 = new HashTable();
        doc1.add("apple");
        doc1.add("apple");
        doc1.add("apple");
        doc1.add("banana");
        doc1.add("banana");

        doc2 = new HashTable();
        doc2.add("apple");
        doc2.add("cherry");
        doc2.add("cherry");
        doc2.add("cherry");
        doc2.add("cherry");

        allDocs = new ArrayList<>();
        allDocs.add(doc1);
        allDocs.add(doc2);

        tfidf = new Tfidf(allDocs);
    }

    @AfterEach
    void tearDown() {
        doc1 = null;
        doc2 = null;
        allDocs = null;
        tfidf = null;
    }


    // calculateTF(term, doc) //

    // TC1: Term is not null and appears in some doc
    @Test
    void testCalculateTF_TC1() {
        double expected = 3.0 / 5.0;
        double tf = tfidf.calculateTF("apple", doc1);
        assertEquals(expected, tf, 0.01);
    }

    // TC2: Term is not null and appears in no doc
    @Test
    void testCalculateTF_TC2() {
        double tf = tfidf.calculateTF("cherry", doc1);
        assertEquals(0.0, tf);
    }

    // TC3: Term is null
    @Test
    void testCalculateTF_TC3() {
        assertThrows(NullPointerException.class, () -> {
            tfidf.calculateTF(null, doc1);
        });
    }

    // TC4: Empty document -> getTotalWord() = 0 -> division by zero error
    @Test
    void testCalculateTF_TC4() {
        HashTable empty = new HashTable();

        assertTrue(Double.isNaN(tfidf.calculateTF("apple", empty)));
    }


    // calculateIDF(term) //

    // TC1: Tern is not null and appears in some docs
    @Test
    void testCalculateIDF_TC1() {
        // count = 2 → ln(2 / (2+1)) = ln(2/3)
        double expected = Math.log(2.0 / 3.0);
        double idf = tfidf.calculateIDF("apple");
        assertEquals(expected, idf, 0.01);
    }

    // TC2: Term is not null and appears in no docs
    @Test
    void testCalculateIDF_TC2() {
        double expected = Math.log(2.0);
        double idf = tfidf.calculateIDF("pear");
        assertEquals(expected, idf, 0.01);
    }

    // TC3: Term is null
    @Test
    void testCalculateIDF_TC3() {
        assertThrows(NullPointerException.class, () -> {
            tfidf.calculateIDF(null);
        });
    }
}

