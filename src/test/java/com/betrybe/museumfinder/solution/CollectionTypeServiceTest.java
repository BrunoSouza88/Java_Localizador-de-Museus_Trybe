package com.betrybe.museumfinder.solution;

import com.betrybe.museumfinder.database.MuseumFakeDatabase;
import com.betrybe.museumfinder.service.CollectionTypeService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

/**
 * javadoc.
 */
@SpringBootTest
@AutoConfigureMockMvc
public class CollectionTypeServiceTest {

  @MockBean
  MuseumFakeDatabase museumFakeDatabase;

  @Autowired
  private CollectionTypeService collectionTypeService;

  @Test
  public void testCountCollectionTypes() {
    Mockito.when(museumFakeDatabase.countByCollectionType(Mockito.any()))
            .thenReturn(492L);

    assert (collectionTypeService.countByCollectionTypes("hist").count()== 492);
    assert (collectionTypeService.countByCollectionTypes("hist").collectionTypes()[0].equals("hist"));
  }
}
