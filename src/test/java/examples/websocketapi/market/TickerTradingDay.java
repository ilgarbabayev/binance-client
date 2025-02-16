package examples.websocketapi.market;

import org.json.JSONObject;

import com.binance.connector.client.WebSocketApiClient;
import com.binance.connector.client.impl.WebSocketApiClientImpl;

public final class TickerTradingDay {

    private TickerTradingDay() {
    }

    private static final int waitTime = 60000;

    public static void main(String[] args) throws InterruptedException {
        WebSocketApiClient client = new WebSocketApiClientImpl();
        client.connect(((event) -> {
            System.out.println(event);
        }));

        JSONObject params = new JSONObject();
        String[] symbols = new String[]{"BTCUSDT", "BNBUSDT"};

        params.put("symbols", symbols);
        client.market().tickerTradingDay(params);

        Thread.sleep(waitTime);
        client.close();

    }
}
