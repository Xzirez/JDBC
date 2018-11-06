package no.kristiania.pgr200.httpserver;

import java.net.Socket;

public class HttpRequest {

    public static void main(String[] args) {
        private String hostname;
        private String uri;
        private int port;

    public HttpRequest(String hostname, int port, String uri) {
            this.hostname = hostname;
            this.uri = uri;
            this.port = port;
        }

        //Denne metoden sender ut header, host, connection status
        public HttpResponse execute() throws IOException {
            try(Socket socket = new Socket(hostname, port)) {
                socket.getOutputStream()
                        .write(("GET " + uri + " HTTP/1.1\r\n").getBytes());
                socket.getOutputStream()
                        .write(("Host: " + hostname + "\r\n").getBytes());
                socket.getOutputStream()
                        .write("Connection: close\r\n".getBytes());
                socket.getOutputStream().write("\r\n".getBytes());


                return new HttpResponse(socket);
            }
        }
    }
}