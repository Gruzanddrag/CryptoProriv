<template>
  <v-dialog
    v-model="dialog"
    fullscreen
    hide-overlay
    transition="dialog-bottom-transition"
  >
    <template v-slot:activator="{ on, attrs }">
      <v-list-item v-bind="attrs" v-on="on">
        <v-list-item-title>Создать заявку</v-list-item-title>
        <v-list-item-icon>
            <v-icon>library_add</v-icon>
        </v-list-item-icon>
    </v-list-item>
    </template>
    <v-card>
      <v-toolbar
        dark
        color="primary"
      >
        <v-btn
          icon
          dark
          @click="dialog = false"
        >
          <v-icon>mdi-close</v-icon>
        </v-btn>
        <v-toolbar-title>Создать заявку на рационализаторское предложение</v-toolbar-title>
        <v-spacer></v-spacer>
        <v-toolbar-items>
          <v-btn
            dark
            text
            @click="dialog = false"
          >
            Сохранить
          </v-btn>
        </v-toolbar-items>
      </v-toolbar>
      <v-list
        three-line
      >
        <v-list-item>
          <v-list-item-content>
            <h2>Заполните поля</h2>
            <v-form class="px-3">
              <v-layout row wrap>
                <v-col cols="6">
                  <v-text-field
                    name="name"
                    label="Название проекта"
                    prepend-icon="drive_file_rename_outline"
                    v-model="title"
                  ></v-text-field>
                  <v-select
                  :items="items"
                  prepend-icon="category"
                  label="Область предложения"
                  v-model="category"
                  ></v-select>
                  <v-text-field
                    name="name"
                    label="Соавторы"
                    prepend-icon="person"
                    v-model="title"
                  ></v-text-field>
                   <v-switch
                      label="Идея является моей и указанных сооавторов"
                    ></v-switch>
                  </v-col>
                  <v-col cols="6">
                    <v-file-input
                      counter
                      multiple
                      show-size
                      small-chips
                      placeholder="Необходимые документы"
                      truncate-length="15"
                    ></v-file-input>
                    <v-file-input
                      counter
                      multiple
                      show-size
                      small-chips
                      placeholder="Дополнительные файлы"
                      truncate-length="15"
                    ></v-file-input>
                      <v-text-field
                      name="idea"
                      label="Новизна"
                      prepend-icon="lightbulb"
                      v-model="title"
                    ></v-text-field>
                  </v-col>
                  <h2 style="margin-bottom: 20px;">Описание рационализаторского предложения</h2>
                  <v-col cols="12">
                  <tiptap-vuetify
                    v-model="content"
                    :extensions="extensions"
                    :toolbar-attributes="{ color: 'yellow' }"
                    elevation="0"
                    min-height="450"
                    :card-props="{ flat: true, color: 'grey lighten-3' }"
                  />
                  </v-col>
              </v-layout>
            </v-form>
          </v-list-item-content>
        </v-list-item>
      </v-list>
    </v-card>
  </v-dialog>
</template>

<script>

import { TiptapVuetify, Heading, Bold, Italic, Strike, Underline, Code, Paragraph, BulletList, OrderedList, ListItem, Link, Blockquote, HardBreak, HorizontalRule, History } from 'tiptap-vuetify';

  export default {
    name: 'createRequest',
    components: {
      TiptapVuetify,
    },
    data: () => ({
    dialog: false,
    extensions: [
      History,
      Blockquote,
      Link,
      Underline,
      Strike,
      Italic,
      ListItem,
      BulletList,
      OrderedList,
      [Heading, {
        options: {
          levels: [1, 2, 3]
        }
      }],
      Bold,
      Code,
      HorizontalRule,
      Paragraph,
      HardBreak
    ],
    // starting editor's content
    content: `
      <h1>В данном поле вам необходимо</h1>
      <h2>объяснить такие темы, как:</h2>
      <ul>
        <li>Экономический доход вашего предложения</li>
        <li>Описание недостатков актуального подхода</li>
        <li>Описание положительного эффекта</li>
        <li>Требуемые сроки на внедрение</li>
        <li>Полезность вашего решения</li>
      <ul>
    `
  })
    
  }
</script>

<style scoped>

</style>