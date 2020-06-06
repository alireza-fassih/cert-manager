<template>
  <v-app id="inspire">
    <MainNavigation ref="navigation" />

    <v-app-bar color="blue-grey" dark fixed app clipped-right>
      <v-spacer></v-spacer>
      <v-toolbar-title>Toolbar</v-toolbar-title>
      <v-app-bar-nav-icon @click.stop="toggleNavigation"></v-app-bar-nav-icon>
    </v-app-bar>

    <v-content class="pa-0">
      <v-container  >
        <router-view></router-view>
      </v-container>
    </v-content>

    <v-footer color="blue-grey" class="white--text" app>
      <span></span>
      <v-spacer></v-spacer>
      <span></span>
    </v-footer>
  </v-app>
</template>

<script>
import RestUtil from "../lib/RestUtil";

import MainNavigation from "./MainNavigation";

export default {
  components: {
    MainNavigation
  },
  data: () => ({}),
  beforeRouteEnter: function(to, from, next) {
    RestUtil.get("/rest/auth/info").then(resp => {
      console.log( resp.data )
      next();
    });
  },
  methods: {
    toggleNavigation: function() {
      this.$refs.navigation.toggleNav();
    }
  },
  props: {
    source: String
  }
};
</script>

<style>
.v-toolbar__content {
    float: right;
}
</style>