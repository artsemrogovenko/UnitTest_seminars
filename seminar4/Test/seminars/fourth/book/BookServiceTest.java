package seminars.fourth.book;


import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

/**
 * есть класс BookService, который использует интерфейс BookRepository для получения информации о книгах из базы данных.
 * Ваша задача написать unit-тесты для BookService, используя Mockito для создания мок-объекта BookRepository.
 */
class BookServiceTest {
    static BookService bookService;

    static BookRepository bookRepository;

    @BeforeAll
    static void init() {
        bookRepository = mock(BookRepository.class);
        bookService = new BookService(bookRepository);

        when(bookRepository.findById("1")).thenReturn(new Book("1", "Book1", "Author1"));
        when(bookRepository.findAll()).thenReturn(List.of
                (new Book("1", "Book1", "Author1"),
                new Book("2", "Book2", "Author2")));
    }

    @Test
    void findBookById() {
        Book book = bookService.findBookById("1");

        assertThat(book.getAuthor()).isNotEqualTo("Author2");
        verify(bookRepository).findById("1");
    }

    @Test
    void findAllBooks() {
        List<Book> books = bookService.findAllBooks();

        assertThat(books).hasSize(2);
        verify(bookRepository).findAll();
    }


}