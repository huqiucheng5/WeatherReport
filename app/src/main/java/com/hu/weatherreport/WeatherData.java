package com.hu.weatherreport;

import java.util.List;

/**
 * Created by huqiucheng on 2017/9/8 0008.
 */

public class WeatherData {


    /**
     * error : 0
     * status : success
     * date : 2017-09-08
     * results : [{"currentCity":"深圳","pm25":"22","index":[{"title":"穿衣","zs":"炎热","tipt":"穿衣指数","des":"天气炎热，建议着短衫、短裙、短裤、薄型T恤衫等清凉夏季服装。"},{"title":"洗车","zs":"不宜","tipt":"洗车指数","des":"不宜洗车，未来24小时内有雨，如果在此期间洗车，雨水和路上的泥水可能会再次弄脏您的爱车。"},{"title":"感冒","zs":"少发","tipt":"感冒指数","des":"各项气象条件适宜，发生感冒机率较低。但请避免长期处于空调房间中，以防感冒。"},{"title":"运动","zs":"较不宜","tipt":"运动指数","des":"有降水，推荐您在室内进行低强度运动；若坚持户外运动，须注意选择避雨防滑地点，并携带雨具。"},{"title":"紫外线强度","zs":"弱","tipt":"紫外线强度指数","des":"紫外线强度较弱，建议出门前涂擦SPF在12-15之间、PA+的防晒护肤品。"}],"weather_data":[{"date":"周五 09月08日 (实时：30℃)","dayPictureUrl":"http://api.map.baidu.com/images/weather/day/leizhenyu.png","nightPictureUrl":"http://api.map.baidu.com/images/weather/night/xiaoyu.png","weather":"雷阵雨转小雨","wind":"无持续风向微风","temperature":"32 ~ 25℃"},{"date":"周六","dayPictureUrl":"http://api.map.baidu.com/images/weather/day/duoyun.png","nightPictureUrl":"http://api.map.baidu.com/images/weather/night/duoyun.png","weather":"多云","wind":"无持续风向微风","temperature":"33 ~ 26℃"},{"date":"周日","dayPictureUrl":"http://api.map.baidu.com/images/weather/day/duoyun.png","nightPictureUrl":"http://api.map.baidu.com/images/weather/night/duoyun.png","weather":"多云","wind":"无持续风向微风","temperature":"33 ~ 26℃"},{"date":"周一","dayPictureUrl":"http://api.map.baidu.com/images/weather/day/qing.png","nightPictureUrl":"http://api.map.baidu.com/images/weather/night/qing.png","weather":"晴","wind":"无持续风向微风","temperature":"33 ~ 27℃"}]}]
     */

    private int error;
    private String status;
    private String date;
    private List<ResultsEntity> results;


    @Override
    public String toString() {
        return "WeatherData{" +
                "error=" + error +
                ", status='" + status + '\'' +
                ", date='" + date + '\'' +
                ", results=" + results +
                '}';
    }

    public void setError(int error) {
        this.error = error;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setResults(List<ResultsEntity> results) {
        this.results = results;
    }

    public int getError() {
        return error;
    }

    public String getStatus() {
        return status;
    }

    public String getDate() {
        return date;
    }

    public List<ResultsEntity> getResults() {
        return results;
    }

    public static class ResultsEntity {
        /**
         * currentCity : 深圳
         * pm25 : 22
         * index : [{"title":"穿衣","zs":"炎热","tipt":"穿衣指数","des":"天气炎热，建议着短衫、短裙、短裤、薄型T恤衫等清凉夏季服装。"},{"title":"洗车","zs":"不宜","tipt":"洗车指数","des":"不宜洗车，未来24小时内有雨，如果在此期间洗车，雨水和路上的泥水可能会再次弄脏您的爱车。"},{"title":"感冒","zs":"少发","tipt":"感冒指数","des":"各项气象条件适宜，发生感冒机率较低。但请避免长期处于空调房间中，以防感冒。"},{"title":"运动","zs":"较不宜","tipt":"运动指数","des":"有降水，推荐您在室内进行低强度运动；若坚持户外运动，须注意选择避雨防滑地点，并携带雨具。"},{"title":"紫外线强度","zs":"弱","tipt":"紫外线强度指数","des":"紫外线强度较弱，建议出门前涂擦SPF在12-15之间、PA+的防晒护肤品。"}]
         * weather_data : [{"date":"周五 09月08日 (实时：30℃)","dayPictureUrl":"http://api.map.baidu.com/images/weather/day/leizhenyu.png","nightPictureUrl":"http://api.map.baidu.com/images/weather/night/xiaoyu.png","weather":"雷阵雨转小雨","wind":"无持续风向微风","temperature":"32 ~ 25℃"},{"date":"周六","dayPictureUrl":"http://api.map.baidu.com/images/weather/day/duoyun.png","nightPictureUrl":"http://api.map.baidu.com/images/weather/night/duoyun.png","weather":"多云","wind":"无持续风向微风","temperature":"33 ~ 26℃"},{"date":"周日","dayPictureUrl":"http://api.map.baidu.com/images/weather/day/duoyun.png","nightPictureUrl":"http://api.map.baidu.com/images/weather/night/duoyun.png","weather":"多云","wind":"无持续风向微风","temperature":"33 ~ 26℃"},{"date":"周一","dayPictureUrl":"http://api.map.baidu.com/images/weather/day/qing.png","nightPictureUrl":"http://api.map.baidu.com/images/weather/night/qing.png","weather":"晴","wind":"无持续风向微风","temperature":"33 ~ 27℃"}]
         */

        private String currentCity;
        private String pm25;
        private List<IndexEntity> index;
        private List<WeatherDataEntity> weather_data;

        public void setCurrentCity(String currentCity) {
            this.currentCity = currentCity;
        }

        public void setPm25(String pm25) {
            this.pm25 = pm25;
        }

        public void setIndex(List<IndexEntity> index) {
            this.index = index;
        }

        public void setWeather_data(List<WeatherDataEntity> weather_data) {
            this.weather_data = weather_data;
        }

        public String getCurrentCity() {
            return currentCity;
        }

        public String getPm25() {
            return pm25;
        }

        public List<IndexEntity> getIndex() {
            return index;
        }

        public List<WeatherDataEntity> getWeather_data() {
            return weather_data;
        }

        public static class IndexEntity {
            /**
             * title : 穿衣
             * zs : 炎热
             * tipt : 穿衣指数
             * des : 天气炎热，建议着短衫、短裙、短裤、薄型T恤衫等清凉夏季服装。
             */

            private String title;
            private String zs;
            private String tipt;
            private String des;

            public void setTitle(String title) {
                this.title = title;
            }

            public void setZs(String zs) {
                this.zs = zs;
            }

            public void setTipt(String tipt) {
                this.tipt = tipt;
            }

            public void setDes(String des) {
                this.des = des;
            }

            public String getTitle() {
                return title;
            }

            public String getZs() {
                return zs;
            }

            public String getTipt() {
                return tipt;
            }

            public String getDes() {
                return des;
            }
        }

        public static class WeatherDataEntity {
            /**
             * date : 周五 09月08日 (实时：30℃)
             * dayPictureUrl : http://api.map.baidu.com/images/weather/day/leizhenyu.png
             * nightPictureUrl : http://api.map.baidu.com/images/weather/night/xiaoyu.png
             * weather : 雷阵雨转小雨
             * wind : 无持续风向微风
             * temperature : 32 ~ 25℃
             */

            private String date;
            private String dayPictureUrl;
            private String nightPictureUrl;
            private String weather;
            private String wind;
            private String temperature;

            public void setDate(String date) {
                this.date = date;
            }

            public void setDayPictureUrl(String dayPictureUrl) {
                this.dayPictureUrl = dayPictureUrl;
            }

            public void setNightPictureUrl(String nightPictureUrl) {
                this.nightPictureUrl = nightPictureUrl;
            }

            public void setWeather(String weather) {
                this.weather = weather;
            }

            public void setWind(String wind) {
                this.wind = wind;
            }

            public void setTemperature(String temperature) {
                this.temperature = temperature;
            }

            public String getDate() {
                return date;
            }

            public String getDayPictureUrl() {
                return dayPictureUrl;
            }

            public String getNightPictureUrl() {
                return nightPictureUrl;
            }

            public String getWeather() {
                return weather;
            }

            public String getWind() {
                return wind;
            }

            public String getTemperature() {
                return temperature;
            }
        }
    }
}
