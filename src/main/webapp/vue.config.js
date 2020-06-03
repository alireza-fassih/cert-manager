module.exports = {
  "transpileDependencies": [
    "vuetify"
  ],
  "devServer": {
    port: 3000,
    proxy: {
      "^/rest": {
        target: 'http://localhost:8080'
      },
      "^/cert": {
        target: 'http://localhost:8080'
      }
    }
  }
}