<template>
  <v-container fluid fill-height>
    <v-layout align-center justify-center>
      <v-flex xs12 sm8 md4>
        <v-card class="elevation-12" :hidden="certLoaded">
          <v-img
            class="white--text align-end"
            height="200px"
            src="https://via.placeholder.com/200C"
          >
            <v-card-title>مشاهده گواهینامه</v-card-title>
          </v-img>

          <v-card-text class="text--primary">
            <v-text-field
              v-model="data.code"
              prepend-icon="mdi-certificate-outline"
              label="کد گواهینامه"
              type="text"
            ></v-text-field>
          </v-card-text>

          <v-card-actions>
            <v-btn :disabled="onRequest" @click="loadCert">مشاهده</v-btn>
          </v-card-actions>

          <v-progress-linear indeterminate :active="onRequest"></v-progress-linear>
        </v-card>

        <v-card  :hidden="!certLoaded">
          <v-img
            :src="loadedCertUrl"
            class="white--text align-end"
            gradient="to bottom, rgba(0,0,0,.1), rgba(0,0,0,.5)"
          >
            <v-card-title v-text=data.code></v-card-title>
          </v-img>

          <v-card-actions>
            <v-spacer></v-spacer>

            <v-btn icon>
              <v-icon>mdi-printer</v-icon>
            </v-btn>

            <v-btn icon>
              <v-icon>mdi-file-pdf</v-icon>
            </v-btn>

            <v-btn icon>
              <v-icon>mdi-share-variant</v-icon>
            </v-btn>
          </v-card-actions>
        </v-card>
      </v-flex>
    </v-layout>
  </v-container>
</template>

<script>
export default {
  data: () => ({
    alert: {},
    data: {
      code: null
    },
    onRequest: false,
    certLoaded: false,
    loadedCertUrl: null
  }),
  methods: {
    loadCert: function() {
      if (this.data.code) {
        this.onRequest = true;
        this.certLoaded = true;
        this.loadedCertUrl = "/cert/loadCert/" + this.data.code;
      }
    }
  }
};
</script>


<style>

[hidden],
template {
  display: none;
}

</style>