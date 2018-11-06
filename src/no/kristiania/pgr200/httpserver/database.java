package no.kristiania.pgr200.httpserver;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

class database {
    private DataSource dataSource;
    public void addTalk(String title, String description, String topic){


    }

    public void
    public List listAll(){
        return ;

    }
    public List<Talk> retriveTalks() throws SQLException {
        try(Connection connection = dataSource.getConnection()){
            String sql = "select * from talk";
            try(PreparedStatement statement = connection.prepareStatement(sql)){
                try(ResultSet rs = statement.executeQuery()){
                    List<Talk> result = new ArrayList<>();
                    while(rs.next()){
                        Talk talk = new Talk(
                                rs.getString("title"),
                                rs.getString("description"),
                                rs.getString("topic"));
                        result.add(talk);
                    }
                    return result;
                }
            }
        }

    }
    public class Talk {
        private String title, description, topic;

        public Talk(String title, String description, String topic) {
            setTitle(title);
            setDescription(description);
            setTopic(topic);
        }

        public Talk() {

        }


        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getTopic() {
            return topic;
        }

        public void setTopic(String topic) {
            this.topic = topic;
        }

        @Override
        public boolean equals(Object o){
            if(!(o instanceof Talk)){
                return false;
            }
            Talk other = (Talk) o;
            return Objects.equals(title, other.title) && Objects.equals(description, other.description)
                    && Objects.equals(topic, other.topic);
        }

        public int hashCode(){
            return Objects.hash(title, description, topic);
        }

        public String toString(){
            return getClass().getSimpleName() + "{title=" + title + ",description=" + description + ",topic=" + topic + "}";
        }
    }

}