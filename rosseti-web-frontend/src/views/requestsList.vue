<template>
  <div class="dashboard">
    <h1 class="subheading grey--text">Активные предложения</h1>
        <v-container class="my-10">
            <v-layout row class="mb-3 pa-3">
                <v-tooltip top>
                    <template v-slot:activator="{ on, attrs }"> 
                        <v-btn 
                        small 
                        text 
                        color="light-blue darken-4" 
                        @click="sortBy('date')" 
                        v-bind="attrs" 
                        v-on="on"
                        >
                            <v-icon left small>date_range</v-icon>
                            <span class="caption text-lowercase">По дате</span>
                        </v-btn>
                    </template>
                    <span>Сортировать по дате</span>
                </v-tooltip>
                <v-tooltip top>
                    <template v-slot:activator="{ on, attrs }"> 
                        <v-btn 
                        small 
                        text 
                        color="light-blue darken-4" 
                        @click="sortBy('title')" 
                        v-bind="attrs" 
                        v-on="on"
                        >
                            <v-icon left small>folder</v-icon>
                            <span class="caption text-lowercase">По названию</span>
                        </v-btn>
                    </template>
                    <span>Сортировать по названию</span>
                </v-tooltip>
            </v-layout>
            <v-card 
                class="pa-6 my-2"
                v-for="statement in statements"
                :key="statement.id"
            >
              <v-layout row wrap>
                <v-flex xs12 md6>
                  <div class="caption grey--text">Область применения</div>
                  <div>{{ statement.category.name }}</div>
                </v-flex>
                <v-flex xs6 sm4 md2>
                  <div class="caption grey--text">Сотрудник</div>
                  <div>{{ statement.author.fIO }}</div>
                </v-flex>
                <v-flex xs6 sm4 md2>
                  <div class="caption grey--text">Описание предложения</div>
                  <div>
                    <span v-html="statement.projectDescription.substring(0,30) + '...' "></span><br>
                  </div>
                </v-flex>
                <v-flex xs2 sm4 md2>
                  <div class="caption grey--text">Статус</div>
                  <div>
                      <v-chip small class="green darken-1 white--text caption my-2">Проверяется</v-chip>
                  </div>
                </v-flex>
              </v-layout>
            </v-card>
        </v-container>
  </div>
</template>

<script>
import axios from "axios"

export default {
    name: 'requestsList',
    data: () => {
        return {
            statements: []
        }
    },
    created() {
        this.reloadStatements()
    },
    methods: {
        reloadStatements() {
            return axios.get(this.$store.state.apiurl + "statements")
            .then(res => {
                this.statements = res.data
            })
        }
    },
}
</script>

<style scoped>
    .dashboard {
        margin: 50px;
    }    
</style>