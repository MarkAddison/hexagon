package hexagon.benchmark

import co.there4.hexagon.rest.HttpClient
import co.there4.hexagon.serialization.parse
import okhttp3.Response
import org.testng.annotations.AfterClass
import org.testng.annotations.BeforeClass
import org.testng.annotations.Test
import java.net.URL

/**
 * <p>TODO
 * Write article about stress test with TestNG (scenarios, combine different tests in scenarios,
 * adding random pauses...)
 */
@Test //(enabled = false, threadPoolSize = 16, invocationCount = 75)
class ApplicationTest {
    private val WARM_UP = 10
    private val ENDPOINT = "http://localhost:5050"

    private var application: Application? = null
    private val client = HttpClient(URL(ENDPOINT))

    @BeforeClass fun setup () {
        application = Application ()
    }

    @BeforeClass fun warmup () {
        (1..WARM_UP).forEach {
            json ()
//            plaintext ()
//            no_query_parameter ()
//            empty_query_parameter ()
//            text_query_parameter ()
//            zero_queries ()
//            one_thousand_queries ()
//            one_query ()
//            ten_queries ()
//            one_hundred_queries ()
//            five_hundred_queries ()
//            fortunes ()
//            no_updates_parameter ()
//            empty_updates_parameter ()
//            text_updates_parameter ()
//            zero_updates ()
//            one_thousand_updates ()
//            one_update ()
//            ten_updates ()
//            one_hundred_updates ()
//            five_hundred_updates ()
        }
    }

    @AfterClass fun close () {
//        application.stop ();
    }

    fun json () {
        val response = client.get ("/json")
        val content = response.body().string()

        checkResponse (response, content, "application/json")
        assert ("Hello, World!" == content.parse(Map::class)["message"])
    }

//    fun plaintext () {
//        HttpResponse response = get (ENDPOINT + "/plaintext");
//        String content = getContent (response);
//
//        checkResponse (response, content, "text/plain");
//        assert "Hello, World!".equals (content);
//    }
//
//    fun no_query_parameter () {
//        HttpResponse response = get (ENDPOINT + "/db");
//        String content = getContent (response);
//
//        checkResponse (response, content, "application/json");
//        Map<?, ?> resultsMap = GSON.fromJson (content, Map.class);
//        assert resultsMap.containsKey ("id") && resultsMap.containsKey ("randomNumber");
//    }
//
//    fun empty_query_parameter () {
//        checkDbRequest ("/query?queries", 1);
//    }
//
//    fun text_query_parameter () {
//        checkDbRequest ("/query?queries=text", 1);
//    }
//
//    fun zero_queries () {
//        checkDbRequest ("/query?queries=0", 1);
//    }
//
//    fun one_thousand_queries () {
//        checkDbRequest ("/query?queries=1000", 500);
//    }
//
//    fun one_query () {
//        checkDbRequest ("/query?queries=1", 1);
//    }
//
//    fun ten_queries () {
//        checkDbRequest ("/query?queries=10", 10);
//    }
//
//    fun one_hundred_queries () {
//        checkDbRequest ("/query?queries=100", 100);
//    }
//
//    fun five_hundred_queries () {
//        checkDbRequest ("/query?queries=500", 500);
//    }
//
//    fun fortunes () {
//        HttpResponse response = get (ENDPOINT + "/fortune");
//        String content = getContent (response);
//        String contentType = response.getEntity ().getContentType ().getValue ();
//
//        assert response.getFirstHeader ("Server") != null;
//        assert response.getFirstHeader ("Date") != null;
//        assert content.contains ("&lt;script&gt;alert(&quot;This should not be displayed");
//        assert content.contains ("フレームワークのベンチマーク");
//        assert "text/html; charset=utf-8".equals (contentType.toLowerCase ());
//    }
//
//    fun no_updates_parameter () {
//        HttpResponse response = get (ENDPOINT + "/update");
//        String content = getContent (response);
//
//        checkResponse (response, content, "application/json");
//        Map<?, ?> resultsMap = GSON.fromJson (content, Map.class);
//        assert resultsMap.containsKey ("id") && resultsMap.containsKey ("randomNumber");
//    }
//
//    fun empty_updates_parameter () {
//        checkDbRequest ("/update?queries", 1);
//    }
//
//    fun text_updates_parameter () {
//        checkDbRequest ("/update?queries=text", 1);
//    }
//
//    fun zero_updates () {
//        checkDbRequest ("/update?queries=0", 1);
//    }
//
//    fun one_thousand_updates () {
//        checkDbRequest ("/update?queries=1000", 500);
//    }
//
//    fun one_update () {
//        checkDbRequest ("/update?queries=1", 1);
//    }
//
//    fun ten_updates () {
//        checkDbRequest ("/update?queries=10", 10);
//    }
//
//    fun one_hundred_updates () {
//        checkDbRequest ("/update?queries=100", 100);
//    }
//
//    fun five_hundred_updates () {
//        checkDbRequest ("/update?queries=500", 500);
//    }

    private fun checkDbRequest (path: String, itemsCount: Int) {
        val response = client.get (ENDPOINT + path)
        val content = response.body().string()

        checkResponse (response, content, "application/json")
        checkResultItems (content, itemsCount)
    }

    private fun checkResponse (res: Response, content: String, contentType: String) {
        assert(res.header ("Server") != null)
        assert(res.header ("Date") != null)
//        assert(content.length == res. ())
//        assert(res.contentType.getValue ().contains (contentType))
    }

    private fun checkResultItems (result: String, size: Int) {
//        val resultsList = GSON.fromJson (result, List.class)
//        assert size == resultsList.size ()
//
//        for (int ii = 0; ii < size; ii++) {
//            Map<?, ?> r = (Map)resultsList.get (ii)
//            assert r.containsKey ("id") && r.containsKey ("randomNumber")
//        }
    }
}